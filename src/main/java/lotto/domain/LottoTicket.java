package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicket {

  private final List<Integer> numbers;

  private LottoTicket(final List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  public static LottoTicket of(final List<Integer> numbers) {
    return new LottoTicket(numbers);
  }

  private void validate(final List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException();
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  @Override
  public String toString() {
    final String str = numbers
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));

    return String.format("[%s]\n", str);
  }
}
