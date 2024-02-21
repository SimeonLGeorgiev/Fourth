package stepDefinitions;

import io.cucumber.java.en.And;
import net.thucydides.core.pages.PageObject;
import pages.CheckoutPage;

public class CheckoutPageSteps extends PageObject {

  private final CheckoutPage checkoutPage = new CheckoutPage();

  @And("I verify Checkout page URL, Quantity and Total Price")
  public void verifyCheckoutPageURLQuantityAndTotalPrice() {
    checkoutPage.verifyURL();
    checkoutPage.verifyQuantity();
    checkoutPage.verifyTotalPrice();
  }
}