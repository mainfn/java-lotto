package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

  public static final Money TICKET_PRICE = Money.of(1_000);
  private final RandomNumbersGenerator randomNumbersGenerator;

  public LottoStore(final RandomNumbersGenerator randomNumbersGenerator) {
    this.randomNumbersGenerator = randomNumbersGenerator;
  }

  private LottoTicket buy(final Money wallet) {
    wallet.decrease(TICKET_PRICE);
    return new LottoTicket(randomNumbersGenerator.generate(6));
  }

  public LottoTickets buyMany(final Money wallet) {
    final List<LottoTicket> boughtTickets = new ArrayList<>();
    // wallet 내의 돈이 다 떨어질 때까지 구매
    while (wallet.isEqualOrMoreThan(TICKET_PRICE)) {
      final LottoTicket boughtTicket = buy(wallet);
      boughtTickets.add(boughtTicket);
    }
    // 구매한 모든 티켓을 LottoTickets에 저장 후 반환
    return LottoTickets.of(boughtTickets);
  }

}
