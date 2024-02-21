package pages;

import static enums.Keys.FIRST_ITEM_PRICE;
import static enums.Keys.ITEM_COUNT;
import static enums.Keys.LOADED_PAGE_ELEMENT;

import Helpers.Utility;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

  public static final String VALUE = "value";
  private static final String PAGE_URL = "https://cart.payments.ebay.com/";
  private static final By PAGE_NAME = By.xpath("//h1[@data-test-id='main-title']");
  private static final By QUANTITY_DROPDOWN = By.xpath("//select[@data-test-id='qty-dropdown']");
  private static final By MAIN_PRICE = By.xpath("//div[@class='item-price font-title-3']/span/span");
  private static final By SECONDARY_PRICE = By.xpath("//div[@class='additional-prices']/div/span/span");

  private static double calculateTotalPrice(double itemPrice, int itemCount) {
    return itemPrice * itemCount;
  }

  public void setItemPageElementToContext() {
    Serenity.setSessionVariable(LOADED_PAGE_ELEMENT).to(PAGE_NAME);
  }

  public void verifyURL() {
    String currentUrl = getDriver().getCurrentUrl();
    Assert.assertEquals(currentUrl, PAGE_URL);
  }

  public void verifyQuantity() {
    int itemCount = Serenity.sessionVariableCalled(ITEM_COUNT);
    int pageItemQuantity = Integer.parseInt(getDriver().findElement(QUANTITY_DROPDOWN).getAttribute(VALUE));
    Assert.assertEquals(itemCount, pageItemQuantity);
  }

  public void verifyTotalPrice() {
    int itemCount = Serenity.sessionVariableCalled(ITEM_COUNT);
    double itemPrice = Serenity.sessionVariableCalled(FIRST_ITEM_PRICE);
    double usdPriceOnThePage = getCheckoutPageUsdPrice();
    double totalPrice = calculateTotalPrice(itemPrice, itemCount);
    Assert.assertEquals(totalPrice, usdPriceOnThePage, 0.001);
  }

  private double getCheckoutPageUsdPrice() {
    String pageFirstTotalPrice = getDriver().findElement(MAIN_PRICE).getText();
    String pageSecondaryTotalPrice = getDriver().findElement(SECONDARY_PRICE).getText();
    String usdPriceAsString = Utility.chooseUsdPrice(pageFirstTotalPrice, pageSecondaryTotalPrice);
    return Utility.convertStringPriceToDouble(usdPriceAsString);
  }
}