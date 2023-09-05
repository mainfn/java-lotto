package lotto.domain;

import java.util.List;

public class LottoDrawingResults {

  private final List<LottoDrawingResult> results;

  private LottoDrawingResults(final List<LottoDrawingResult> results) {
    this.results = results;
  }


  public static LottoDrawingResults of(final List<LottoDrawingResult> lottoDrawingResults) {
    return new LottoDrawingResults(lottoDrawingResults);
  }
}