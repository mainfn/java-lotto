package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoDrawingMachine;
import lotto.domain.LottoStore;
import lotto.domain.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

  public static void main(final String[] args) {
    final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(1, 45);
    final LottoStore lottoStore = new LottoStore(randomNumbersGenerator);
    final LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(randomNumbersGenerator);
    final OutputView outputView = new OutputView();
    final InputView inputView = new InputView(outputView);
    final LottoController lottoController = new LottoController(inputView, outputView, lottoStore,
        lottoDrawingMachine);

    lottoController.start();
  }
}
