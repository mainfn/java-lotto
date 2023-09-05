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

  @Override
  public String toString() {

    return String.format(
        "당첨 통계\n"
            + "---\n"
            + "3개 일치 (%d원) - %d개\n"
            + "4개 일치 (%d원) - %d개\n"
            + "5개 일치 (%d원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (%d원) - %d개\n"
            + "6개 일치 (%d원) - %d개\n"
            + "총 수익률은 %.1f%%입니다.\n",
        LottoDrawingResult.FIFTH.getPrizeAmount(),
        countOf(LottoDrawingResult.FIFTH),
        LottoDrawingResult.FOURTH.getPrizeAmount(),
        countOf(LottoDrawingResult.FOURTH),
        LottoDrawingResult.THIRD.getPrizeAmount(),
        countOf(LottoDrawingResult.THIRD),
        LottoDrawingResult.SECOND.getPrizeAmount(),
        countOf(LottoDrawingResult.SECOND),
        LottoDrawingResult.FIRST.getPrizeAmount(),
        countOf(LottoDrawingResult.FIRST),
        getRateOfReturn()
    );
  }

  // 수익률 계산
  private double getRateOfReturn() {
    final double totalEarning = getTotalEarning();
    final double totalSpent = getTotalSpent();

    final double rateOfReturn = totalEarning / totalSpent * 100.0;

    return Math.round(rateOfReturn * 10.0) / 10.0;
  }

  private int getTotalEarning() {
    int totalEarning = 0;

    for (final LottoDrawingResult result : results) {
      totalEarning += result.getPrizeAmount();
    }

    return totalEarning;
  }

  private int getTotalSpent() {
    return LottoStore.TICKET_PRICE.getAmount() * results.size();
  }

  private int countOf(final LottoDrawingResult variant) {
    return (int) results.stream()
        .filter(v -> v.equals(variant))
        .count();
  }
}