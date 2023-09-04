package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {

  private final OutputView outputView;

  public InputView(final OutputView outputView) {
    this.outputView = outputView;
  }

  public Integer inputPurchaseAmount() {
    outputView.printInputPurchaseAmountMessage();
    return Integer.parseInt(readLine());
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
