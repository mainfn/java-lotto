package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;

public final class InputManager {

  public Money inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    final int amount = Integer.parseInt(Console.readLine());

    return Money.of(amount);
  }

  public Lotto inputLotto() {
    final List<Integer> numbers = inputWinningNumbers();
    System.out.println();

    final int bonusNumber = inputBonusNumber();
    System.out.println();

    return Lotto.of(numbers, bonusNumber);
  }

  private List<Integer> inputWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요.");
    return Arrays.stream(
            Console.readLine()
                .split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private int inputBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    return Integer.parseInt(Console.readLine());
  }
}
