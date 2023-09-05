package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoDrawingMachine {

  private final RandomNumbersGenerator randomNumbersGenerator;
  private List<Integer> winningNumbers;
  private int bonusNumber;

  public LottoDrawingMachine(final RandomNumbersGenerator randomNumbersGenerator) {
    this.randomNumbersGenerator = randomNumbersGenerator;
  }

  public LottoDrawingResults getResults(final LottoTickets lottoTickets) {
    // 당첨 번호를 아직 뽑지 않은 경우
    if (winningNumbers == null) {
      throw new IllegalStateException("[ERROR] 당첨 결과 비교를 위해 먼저 추첨을 진행해주세요.");
    }
    // 당첨 번호와 비교 후 결과 반환
    return lottoTickets.drawResults(winningNumbers, bonusNumber);
  }

  public void drawManually(
      final List<Integer> winningNumbers,
      final int bonusNumber
  ) {
    validateLength(winningNumbers);
    validateNumbersDuplication(winningNumbers, bonusNumber);
    this.winningNumbers = winningNumbers;
    this.bonusNumber = bonusNumber;
  }

  private void validateLength(final List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
    }
  }

  private void validateNumbersDuplication(
      final List<Integer> numbers,
      final int bonusNumber
  ) {
    final List<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
    numbersWithBonusNumber.add(bonusNumber);

    for (final Integer number : numbersWithBonusNumber) {
      final long numberCount = numbersWithBonusNumber.stream().filter(n -> n.equals(number))
          .count();
      if (numberCount > 1) {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
      }
    }
  }

}
