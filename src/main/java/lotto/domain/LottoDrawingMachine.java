package lotto.domain;

import java.util.List;

public final class LottoDrawingMachine {

  private final RandomNumbersGenerator randomNumbersGenerator;
  private List<Integer> numbers;
  private int bonusNumber;

  public LottoDrawingMachine(final RandomNumbersGenerator randomNumbersGenerator) {
    this.randomNumbersGenerator = randomNumbersGenerator;
  }

  public void draw() {
    // numbers에 새로운 6자리 랜덤 숫자 저장
    // bonusNumber에 새로운 랜덤 숫자 저장
    final List<Integer> numbers = randomNumbersGenerator.generate(7);
    final Integer bonusNumber = numbers.remove(0);
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public LottoDrawingResults getResults(final LottoTickets lottoTickets) {
    // 당첨 번호를 아직 뽑지 않은 경우
    if (numbers == null) {
      throw new IllegalStateException("당첨 결과 비교를 위해 먼저 추첨을 진행해주세요.");
    }
    // 당첨 번호와 비교 후 결과 반환
    return lottoTickets.drawResults(numbers, bonusNumber);
  }


}
