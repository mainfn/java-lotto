package lotto.controller;

import java.util.List;
import lotto.domain.LottoDrawingMachine;
import lotto.domain.LottoDrawingResults;
import lotto.domain.LottoStore;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoController {

  private final InputView inputView;
  private final OutputView outputView;

  private final LottoStore lottoStore;

  private final LottoDrawingMachine lottoDrawingMachine;

  public LottoController(
      final InputView inputView,
      final OutputView outputView,
      final LottoStore lottoStore,
      final LottoDrawingMachine lottoDrawingMachine
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.lottoStore = lottoStore;
    this.lottoDrawingMachine = lottoDrawingMachine;
  }

  public void start() {
    // 1. 구입 금액 받아오기
    final Money money = inputView.inputMoney();

    // 2. 투입한 금액만큼 로또 구매하기
    final LottoTickets lottoTickets = lottoStore.buyMany(money);

    // 3. 구매한 로또 정보 출력하기
    outputView.printLottoTicketsInfoMessage(lottoTickets);

    // 4. 당첨 번호 입력 받기
    final List<Integer> winningNumbers = inputView.inputWinningNumbers();

    // 5. 보너스 번호 입력 받기
    final Integer bonusNumber = inputView.inputBonusNumber();

    // 6. 로또 추첨하기(당첨 번호 및 보너스 번호 뽑기)
    lottoDrawingMachine.drawManually(winningNumbers, bonusNumber);

    // 7. 구매한 로또 추첨 결과 가져오기
    final LottoDrawingResults lottoDrawingResults = lottoDrawingMachine.getResults(lottoTickets);

    // 8. 당첨 통계 출력하기
    outputView.printLottoDrawingResults(lottoDrawingResults);

  }
}
