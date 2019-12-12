package com.cdk;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Pravesh Lodwal
 * This class represents to each discount entity
 */
public class DiscountRate implements Serializable {

  /**
   * This filed represent minimum value of amount for discount
   */
  private int minimumAmount;

  /**
   * This filed represent maximum value of amount for discount
   */
  private int maximumAmount;

  /**
   * This filed represent discount percentage
   */
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
