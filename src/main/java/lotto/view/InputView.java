package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Money;

public final class InputView {

  private final OutputView outputView;

  public InputView(final OutputView outputView) {
    this.outputView = outputView;
  }

  public Money inputMoney() {
    outputView.printInputMoneyMessage();

    final int amount = Integer.parseInt(readLine());
    if (amount % 1000 != 0) {
      throw new IllegalArgumentException("로또 구입 금액은 반드시 1,000원 단위로 나누어 떨어져야 합니다.");
    }
    return Money.of(amount);
  }

  public List<Integer> inputWinningNumbers() {
    outputView.printInputWinningNumbersMessage();

    return Arrays.stream(readLine().split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public Integer inputBonusNumber() {
    outputView.printInputBonusNumbersMessage();

    return Integer.parseInt(readLine());
  }

  private String readLine() {
    return Console.readLine().trim();
  }
}
