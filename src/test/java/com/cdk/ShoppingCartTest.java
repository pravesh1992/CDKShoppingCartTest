package com.cdk;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {

  @Test
  public void test_billingAMount_less_than_5000() {
    ShoppingCart shoppingCart = new ShoppingCart();
    int finalBillingAMount = shoppingCart.getFinalBillAmount(5000, ShoppingCart.defaultDiscountRates);
    Assert.assertEquals(finalBillingAMount, 5000);
  }

  @Test
  public void test_billingAMount_greater_than_5000_and_less_than_10000() {
    ShoppingCart shoppingCart = new ShoppingCart();
    int finalBillingAMount = shoppingCart.getFinalBillAmount(10000, ShoppingCart.defaultDiscountRates);
    Assert.assertEquals(finalBillingAMount, 9000);
  }

  @Test
  public void test_billingAMount_greater_than_10000() {
    ShoppingCart shoppingCart = new ShoppingCart();
    int finalBillingAMount = shoppingCart.getFinalBillAmount(15000, ShoppingCart.defaultDiscountRates);
    Assert.assertEquals(finalBillingAMount, 12000);
  }
}
