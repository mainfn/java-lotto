package lotto.domain;

public enum LottoResult {
  NONE,
  FIRST,
  SECOND,
  THIRD,
  FOURTH,
  FIFTH;

  public static LottoResult create(
      final int matchedNumbersCount,
      final boolean containsBonusNumber
  ) {
    if (matchedNumbersCount == 6) {
      return LottoResult.FIRST;
    }

    if (matchedNumbersCount == 5 && containsBonusNumber) {
      return LottoResult.SECOND;
    }

    if (matchedNumbersCount == 5) {
      return LottoResult.THIRD;
    }

    if (matchedNumbersCount == 4) {
      return LottoResult.FOURTH;
    }

    if (matchedNumbersCount == 3) {
      return LottoResult.FIFTH;
    }

    return LottoResult.NONE;
  }

  public int getAmount() {
    switch (this) {
      case FIRST:
        return 2000000000;
      case SECOND:
        return 30000000;
      case THIRD:
        return 1500000;
      case FOURTH:
        return 50000;
      case FIFTH:
        return 5000;
    }
    return 0;
  }
}

