package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResultsHolder;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.view.LottoView;

public final class LottoController {

  private final InputManager inputManager;
  private final LottoStore lottoStore;
  private final LottoView lottoView;


  public LottoController(
      final InputManager inputManager,
      final LottoStore lottoStore,
      final LottoView lottoView
  ) {
    this.inputManager = inputManager;
    this.lottoStore = lottoStore;
    this.lottoView = lottoView;
  }

  public void start() {

    // 1. 구입 금액 입력
    final Money money = inputManager.inputMoney();

    // 2. 구입 금액으로 가능한 만큼 LotteryTicket 구매
    final List<LottoTicket> lottoTickets = lottoStore.buy(money);
    // 구매 내역 출력
    lottoView.printBoughtTickets(lottoTickets);

    // 3. 당첨 번호 및 보너스 번호 입력
    final Lotto lotto = inputManager.inputLotto();
    final LottoResultsHolder results = lotto.getResults(lottoTickets);

    // 4. 당첨 통계 출력
    // view
    lottoView.printResult(results);
  }
}
