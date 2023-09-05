# Domain Objects

## 1. LottoTicket

- 사용자가 입력한 로또 번호를 저장한다.

## 2. LottoTickets

- LottoTicket 여러 개를 들고 있는 일급 컬렉션(LottoTicket 여러 장을 구매할 것이기 때문에 필요)

## 3. RandomLottoTicketGenerator

- 임의의 로또 번호 6자리를 생성하여 LottoTicket을 만들고 반환한다.

## 4. Money

- 자금 정보를 저장한다.
- 자금 증감 연산을 지원한다.

## 5. LottoStore

- buy: Money를 인자로 받아서 LottoTicket을 액수에 맞게 발급하여 LottoTickets에 담아 반환한다.

## 6. LottoDrawingMachine

- 로또 당첨 번호 및 보너스 번호를 알고 있다.(생성 시 입력)
- LottoTicket를 받아서 당첨 번호와 대조하여 결과를 LottoDrawingResult로 반환한다.

## 7. LottoDrawingResult

- Lotto 추첨 결과를 담고 있다.(구매 금액, 당첨 통계, 수익률 등)
- toString으로 출력에 맞게 포맷팅 하는 기능