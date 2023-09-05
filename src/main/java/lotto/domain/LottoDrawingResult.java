package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoDrawingResult {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  NONE(0, false, 0);

  private static final List<LottoDrawingResult> results =
      Arrays.stream(values())
          .collect(Collectors.toList());

  private final int matchingNumbersCount;
  private final boolean hasBonusNumber;
  private final int prizeAmount;

  LottoDrawingResult(
      final int matchingNumbersCount,
      final boolean hasBonusNumber,
      final int prizeAmount
  ) {
    this.matchingNumbersCount = matchingNumbersCount;
    this.hasBonusNumber = hasBonusNumber;
    this.prizeAmount = prizeAmount;
  }

  public static LottoDrawingResult of(
      final int matchingNumbersCount,
      final boolean hasBonusNumber
  ) {
    if (matchingNumbersCount == 5 && hasBonusNumber) {
      return LottoDrawingResult.SECOND;
    }

    final Optional<LottoDrawingResult> result = results.stream()
        .filter(r -> r.matchingNumbersCount == matchingNumbersCount)
        .filter(r -> !r.equals(LottoDrawingResult.SECOND))
        .findFirst();

    if (result.isPresent()) {
      return result.get();
    }

    return LottoDrawingResult.NONE;
  }

  public int getPrizeAmount() {
    return prizeAmount;
  }
}
