package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {

  private final List<Integer> numbers;

  private final int bonusNumber;

  private Lotto(
      final List<Integer> numbers,
      final int bonusNumber
  ) {
    validate(numbers);
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public static Lotto of(
      final List<Integer> numbers,
      final int bonusNumber
  ) {
    return new Lotto(numbers, bonusNumber);
  }

  private void validate(final List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }
    validateLottoNumber(numbers);
  }

  public void validateLottoNumber(final List<Integer> numbers) {
    numbers.forEach(number -> {
      if (number < 1 || number > 45) {
        throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
      }
    });
    int numbersCount = new HashSet<>(numbers).size();
    if (numbersCount != 6) {
      throw new IllegalArgumentException("로또 중복 숫자는 불가");
    }
  }

  // TODO: 추가 기능 구현
  public LottoResultsHolder getResults(final List<LottoTicket> lottoTickets) {
    return LottoResultsHolder.of(
        lottoTickets.stream()
            .map(this::getResult)
            .collect(Collectors.toList())
    );
  }

  public LottoResult getResult(final LottoTicket lottoTicket) {
    final int matchedNumbersCount = getMatchedNumbersCount(lottoTicket);
    final boolean containsBonusNumber = containsBonusNumber(lottoTicket);

    return LottoResult.create(matchedNumbersCount, containsBonusNumber);
  }

  private int getMatchedNumbersCount(final LottoTicket lottoTicket) {
    return (int) lottoTicket.getNumbers().stream()
        .filter(numbers::contains)
        .count();
  }

  private boolean containsBonusNumber(final LottoTicket lottoTicket) {
    return lottoTicket.getNumbers()
        .stream()
        .anyMatch(number -> number == bonusNumber);
  }
}
