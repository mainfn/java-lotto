package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTickets {

  private final List<LottoTicket> lottoTickets;

  private LottoTickets(final List<LottoTicket> lottoTickets) {
    this.lottoTickets = lottoTickets;
  }


  public static LottoTickets of(final List<LottoTicket> lottoTickets) {
    return new LottoTickets(lottoTickets);
  }

  public LottoDrawingResults drawResults(
      final List<Integer> winningNumbers,
      final int bonusNumber
  ) {
    final List<LottoDrawingResult> lottoDrawingResults = new ArrayList<>();

    for (final LottoTicket lottoTicket : lottoTickets) {
      final LottoDrawingResult lottoDrawingResult = lottoTicket.drawResult(winningNumbers,
          bonusNumber);
      lottoDrawingResults.add(lottoDrawingResult);
    }

    return LottoDrawingResults.of(lottoDrawingResults);
  }

}
