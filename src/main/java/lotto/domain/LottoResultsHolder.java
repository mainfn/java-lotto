package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;

public final class LottoResultsHolder {

  private final List<LottoResult> lottoResultList;
  private final DecimalFormat decimalFormat;

  private LottoResultsHolder(final List<LottoResult> lottoResultList) {
    this.lottoResultList = lottoResultList;
    this.decimalFormat = new DecimalFormat("#.##");
    decimalFormat.setMaximumFractionDigits(2);
  }

  public static LottoResultsHolder of(final List<LottoResult> lottoResultList) {
    return new LottoResultsHolder(lottoResultList);
  }

  @Override
  public String toString() {
    return String.format("3개 일치 - (5,000원) - %d개\n", getCountOf(LottoResult.FIFTH))
        + String.format("4개 일치 - (50,000원) - %d개\n", getCountOf(LottoResult.FOURTH))
        + String.format("5개 일치 - (1,500,000원) - %d개\n", getCountOf(LottoResult.THIRD))
        + String.format("5개 일치, 보너스 볼 일치 - (30,000,000원) - %d개\n", getCountOf(LottoResult.SECOND))
        + String.format("6개 일치 - (2,000,000,000원) - %d개\n", getCountOf(LottoResult.FIRST))
        + String.format("총 수익률은 %s%%입니다.\n", decimalFormat.format(getRevenueRate()));
  }

  public double getRevenueRate() {
    return Math.round((double) getTotalRevenue() / getTotalCost());
  }

  public int getTotalRevenue() {
    return lottoResultList.stream()
        .map(LottoResult::getAmount)
        .reduce(0, Integer::sum);
  }

  public int getTotalCost() {
    return lottoResultList.size() * 1000;
  }

  private int getCountOf(final LottoResult source) {
    return (int) lottoResultList.stream()
        .filter(target -> target == source)
        .count();
  }

}
