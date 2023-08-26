package lotto;

import lotto.controller.InputManager;
import lotto.controller.LottoController;
import lotto.domain.LotteryTicketGenerator;
import lotto.domain.LottoStore;
import lotto.view.LottoView;

public class Application {

  public static void main(String[] args) {
    final InputManager inputManager = new InputManager();
    final LotteryTicketGenerator lotteryTicketGenerator = new LotteryTicketGenerator();
    final LottoStore lottoStore = new LottoStore(lotteryTicketGenerator);
    final LottoView lottoView = new LottoView();
    final LottoController lottoController = new LottoController(inputManager, lottoStore,
        lottoView);

    lottoController.start();
  }
}
