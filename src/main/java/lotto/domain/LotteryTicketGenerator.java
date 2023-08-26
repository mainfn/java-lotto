package lotto.domain;

import java.util.List;
import lib.RandomNumbersGenerator;

public final class LotteryTicketGenerator {

  private final RandomNumbersGenerator randomNumbersGenerator =
      new RandomNumbersGenerator(1, 45, 6);

  public LottoTicket generate() {
    List<Integer> numbers = randomNumbersGenerator.generateUniqueRandomNumbers();
    return LottoTicket.of(numbers);
  }

}
