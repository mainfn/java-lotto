package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

  private final LotteryTicketGenerator lotteryTicketGenerator;

  public LottoStore(final LotteryTicketGenerator lotteryTicketGenerator) {
    this.lotteryTicketGenerator = lotteryTicketGenerator;
  }

  public List<LottoTicket> buy(final Money money) {
    final List<LottoTicket> boughtLottoTickets = new ArrayList<>();

    while (money.getAmount() >= 1000) {
      money.decrease(1000);
      boughtLottoTickets.add(lotteryTicketGenerator.generate());
    }

    return boughtLottoTickets;
  }

}
