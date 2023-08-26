package lotto.view;

import java.util.List;
import lotto.domain.LottoResultsHolder;
import lotto.domain.LottoTicket;

public final class LottoView {

  public void printResult(final LottoResultsHolder lottoResultsHolder) {
    System.out.println("당첨 통계");
    System.out.println("---");
    System.out.println(lottoResultsHolder.toString());
  }

  public void printBoughtTickets(final List<LottoTicket> lottoTickets) {
    final StringBuilder sb = new StringBuilder();
    sb.append(String.format("\n%d개를 구매했습니다.\n", lottoTickets.size()));

    for (final LottoTicket lottoTicket : lottoTickets) {
      sb.append(lottoTicket.toString());
    }
    System.out.println(sb);
  }
}
