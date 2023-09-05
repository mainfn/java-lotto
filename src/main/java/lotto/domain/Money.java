package lotto.domain;

public final class Money {

  private int amount;

  public Money(final int amount) {
    validateAmount(amount);
    this.amount = amount;
  }

  public static Money of(final int amount) {
    return new Money(amount);
  }

  public boolean isEqualOrMoreThan(final Money other) {
    return amount >= other.amount;
  }

  // TODO: 이후 필요에 따라 기능 추가
  public void increase(final Money other) {
    amount += other.amount;
  }

  public void decrease(final Money other) {
    final int nextAmount = amount - other.amount;
    validateAmount(nextAmount);
    amount = nextAmount;
  }


  private void validateAmount(final int amount) {
    if (amount < 0) {
      throw new IllegalStateException("잔액은 음수가 될 수 없습니다.");
    }
  }
}
