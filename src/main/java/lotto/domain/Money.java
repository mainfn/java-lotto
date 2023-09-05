package lotto.domain;

public final class Money {

  private int amount;

  public Money(final int amount) {
    validateAmount(amount);
    this.amount = amount;
  }

  // TODO: 이후 필요에 따라 기능 추가
  public void increase(final int amount) {
    final int nextAmount = this.amount + amount;
    validateAmount(nextAmount);
    this.amount = nextAmount;
  }

  public void decrease(final int amount) {
    final int nextAmount = this.amount - amount;
    validateAmount(nextAmount);
    this.amount = nextAmount;
  }


  private void validateAmount(final int amount) {
    if (amount < 0) {
      throw new IllegalStateException("잔액은 음수가 될 수 없습니다.");
    }
  }
}
