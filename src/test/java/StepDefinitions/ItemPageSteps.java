package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Set;
import net.thucydides.core.pages.PageObject;
import pages.CheckoutPage;
import pages.ItemPage;

public class ItemPageSteps extends PageObject {

  private final ItemPage itemPage = new ItemPage();
  private final CheckoutPage checkoutPage = new CheckoutPage();

  @Then("I change to Item tab")
  public void changeToItemTab() {
    Set<String> windowHandles = getDriver().getWindowHandles();
    getDriver().switchTo().window(windowHandles.stream().reduce((s, s2) -> s2).get());
  }

  @Then("I verify price is the same as previous page")
  public void verifyPriceIsTheSameAsPreviousPage() {
    itemPage.verifyPrice();
  }

  @And("I verify shipping to {word} exist")
  public void verifyShippingToBulgariaExist(String countryName) {
    itemPage.verifyShippingToCountry(countryName);
  }

  @And("I add to Cart {int} items")
  public void addToCartItems(int itemCount) {
    itemPage.addToCart(itemCount);
    checkoutPage.setItemPageElementToContext();
  }
}