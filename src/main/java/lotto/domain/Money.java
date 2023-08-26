package lotto.domain;

public final class Money {

  private int amount;

  private Money(final int amount) {
    this.amount = amount;
  }

  public static Money of(final int amount) {
    return new Money(amount);
  }

  public int getAmount() {
    return amount;
  }

  public void increase(final int amount) {
    this.amount += amount;
  }

  public void decrease(final int amount) {
    this.amount -= amount;
  }
}
