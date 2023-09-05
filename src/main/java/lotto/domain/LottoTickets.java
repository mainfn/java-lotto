package lotto.domain;

import java.util.List;

public final class LottoTickets {

  private final List<LottoTicket> lottoTickets;

  private LottoTickets(final List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }


  public static LottoTickets of(final List<LottoTicket> lottoTickets) {
    return new LottoTickets(lottoTickets);
  }
}
