package com.cdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pravesh Lodwal
 * This class contains apis to calculate finall bill based on given user bill and discount rates
 */
public class ShoppingCart {

  private static Scanner scanner;

  public static List<DiscountRate> defaultDiscountRates;

  static {
    scanner = new Scanner(System.in);
    defaultDiscountRates = new ArrayList<>(5);
    defaultDiscountRates.add(new DiscountRate(0, 5000, 0));
    defaultDiscountRates.add(new DiscountRate(5000, 10000, 10.0f));
    defaultDiscountRates.add(new DiscountRate(10000, Integer.MAX_VALUE, 20.0f));
  }

  public static void main(String[] args) {
    ShoppingCart cdkTest = new ShoppingCart();
    System.out.println("Please provide billing amount: ");
    int billAmount = scanner.nextInt();
    List<DiscountRate> discountRates = new ArrayList<>(10);
    discountRates.add(new DiscountRate(0, 5000, 0));
    discountRates.add(new DiscountRate(5000, 10000, 5.0f));
    discountRates.add(new DiscountRate(10000, 20000, 10.0f));
    discountRates.add(new DiscountRate(20000, 50000, 15.0f));
    discountRates.add(new DiscountRate(50000, Integer.MAX_VALUE, 20.0f));
    System.out.println("Final bill amount after discount : " + cdkTest.getFinalBillAmount(billAmount, discountRates));
  }

  /**
   * This api is used to find final billing for given bill amount based on given discount rates
   *
   * @param billAmount       - Bill amount
   * @param discountRateList - List of {@link DiscountRate}
   * @return - Final bill amount
   */
  public int getFinalBillAmount(int billAmount, List<DiscountRate> discountRateList) {
    if (discountRateList == null || discountRateList.isEmpty()) {
      discountRateList = defaultDiscountRates;
    }

    DiscountRate finalDiscountRate;
    finalDiscountRate = discountRateList.stream().filter(discountRate -> {
      DiscountRate oRate = null;
      if (discountRate.getMaximumAmount() == billAmount) {
        oRate = discountRate;
      } else {
        if (billAmount >= discountRate.getMinimumAmount() && billAmount <= discountRate.getMaximumAmount()) {
          oRate = discountRate;
        }
      }
      return oRate != null;
    }).findAny().orElse(null);


    if (finalDiscountRate == null) {
      return billAmount;
    } else {
      if (finalDiscountRate.getDiscountPercentage() == 0.0f)
        return billAmount;
      else {
        return (int) (billAmount - ((billAmount * finalDiscountRate.getDiscountPercentage()) / 100));
      }
    }
  }
}