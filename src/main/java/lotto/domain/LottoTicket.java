package lotto.domain;

import java.util.List;

public final class LottoTicket {

  private final List<Integer> numbers;

  public LottoTicket(final List<Integer> numbers) {
    this.numbers = numbers;
  }

  public LottoDrawingResult drawResult(
      final List<Integer> winningNumbers,
      final int bonusNumber
  ) {
    final int winningNumbersCount = getWinningNumbersCount(winningNumbers);
    final boolean hasBonusNumber = hasBonusNumber(bonusNumber);
    return LottoDrawingResult.of(winningNumbersCount, hasBonusNumber);
  }

  private int getWinningNumbersCount(final List<Integer> winningNumbers) {
    return (int) winningNumbers.stream()
        .filter(numbers::contains)
        .count();
  }


  private boolean hasBonusNumber(final int bonusNumber) {
    return numbers.contains(bonusNumber);
  }
}
