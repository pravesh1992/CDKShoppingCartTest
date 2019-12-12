package com.cdk;

import java.io.Serializable;
import java.util.Objects;

public class DiscountRate implements Serializable {

  private int minimumAmount;

  private int maximumAmount;

  private float discountPercentage;

  public DiscountRate(int minimumAmount, int maximumAmount, float discountPercentage) {
    this.minimumAmount = minimumAmount;
    this.maximumAmount = maximumAmount;
    this.discountPercentage = discountPercentage;
  }

  public int getMinimumAmount() {
    return minimumAmount;
  }

  public void setMinimumAmount(int minimumAmount) {
    this.minimumAmount = minimumAmount;
  }

  public int getMaximumAmount() {
    return maximumAmount;
  }

  public void setMaximumAmount(int maximumAmount) {
    this.maximumAmount = maximumAmount;
  }

  public float getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(float discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DiscountRate)) return false;
    DiscountRate that = (DiscountRate) o;
    return getMinimumAmount() == that.getMinimumAmount() &&
      getMaximumAmount() == that.getMaximumAmount() &&
      Float.compare(that.getDiscountPercentage(), getDiscountPercentage()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMinimumAmount(), getMaximumAmount(), getDiscountPercentage());
  }
}
