package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicket {

  private final List<Integer> numbers;

  public LottoTicket(final List<Integer> numbers) {
    validateLength(numbers);
    validateNumbersDuplication(numbers);
    this.numbers = numbers;
  }

  private void validateLength(final List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  private void validateNumbersDuplication(final List<Integer> numbers) {
    for (final Integer number : numbers) {
      final long numberCount = numbers.stream().filter(n -> n.equals(number)).count();
      if (numberCount > 1) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
      }
    }
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

  @Override
  public String toString() {
    return numbers.stream()
        .sorted()
        .collect(Collectors.toList())
        .toString();
  }

}
