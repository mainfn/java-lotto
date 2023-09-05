package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

  private static final Money ticketCost = Money.of(1_000);
  private final RandomNumbersGenerator randomNumbersGenerator;

  public LottoStore(final RandomNumbersGenerator randomNumbersGenerator) {
    this.randomNumbersGenerator = randomNumbersGenerator;
  }

  public LottoTicket buy(final Money wallet) {
    wallet.decrease(ticketCost);
    return new LottoTicket(randomNumbersGenerator.generate(6));
  }

  public LottoTickets buyMany(final Money wallet) {
    final List<LottoTicket> boughtTickets = new ArrayList<>();
    // wallet 내의 돈이 다 떨어질 때까지 구매
    while (wallet.isEqualOrMoreThan(ticketCost)) {
      final LottoTicket boughtTicket = buy(wallet);
      boughtTickets.add(boughtTicket);
    }
    // 구매한 모든 티켓을 LottoTickets에 저장 후 반환
    return LottoTickets.of(boughtTickets);
  }

}
