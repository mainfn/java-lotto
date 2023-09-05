package lotto.domain;

public final class LottoStore {

  private static final Money ticketCost = Money.of(1_000);
  private final RandomLottoTicketGenerator randomLottoTicketGenerator;

  public LottoStore(final RandomLottoTicketGenerator randomLottoTicketGenerator) {
    this.randomLottoTicketGenerator = randomLottoTicketGenerator;
  }

  public LottoTicket buy(final Money wallet) {
    wallet.decrease(ticketCost);
    return randomLottoTicketGenerator.generate();
  }

}
