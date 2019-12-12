package com.cdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    System.out.println("Final bill amount after discount : " + cdkTest.getFinalBillAmount(billAmount, defaultDiscountRates));
  }

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