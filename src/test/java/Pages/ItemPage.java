package pages;

import static enums.Keys.FIRST_ITEM_PRICE;
import static enums.Keys.ITEM_COUNT;
import static enums.Keys.LOADED_PAGE_ELEMENT;

import Helpers.Utility;
import java.util.List;
import lombok.extern.log4j.Log4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j
public class ItemPage extends PageObject {
  public static final String OPTION = "option";
  private static final By ITEM_TITLE =
      By.xpath("(//span[contains(@class, \"ux-textspans ux-textspans--BOLD\") and contains(text(), \"Monopoly\")])[1]");
  private static final By SECONDARY_PRICE =
      By.xpath("//div[@class='x-price-approx']//span[@class='ux-textspans ux-textspans--SECONDARY ux-textspans--BOLD']");
  private static final By PRIMARY_PRICE = By.xpath("//div[@class='x-price-primary']/span[@class='ux-textspans']");
  private static final By SHIPPING_TAB = By.xpath("//div[@role='tablist']//span[contains(text(), 'Shipping, returns, and payments')]");
  private static final By COUNTRY_DROPDOWN_MENU = By.xpath("//select[@id='shCountry' and @name='country']");
  private static final By QUANTITY = By.xpath("//input[@id='qtyTextBox']");
  private static final By ADD_TO_CART_BUTTON = By.xpath("//span[@class='ux-call-to-action__text' and text()='Add to cart']");

  public void setItemPageElementToContext() {
    Serenity.setSessionVariable(LOADED_PAGE_ELEMENT).to(ITEM_TITLE);
  }


  public void verifyPrice() {
    String priceFromFirstPageAsString = Serenity.sessionVariableCalled(FIRST_ITEM_PRICE);
    double priceFromFirstPage = Utility.convertStringPriceToDouble(priceFromFirstPageAsString);
    double priceFromItemPage = getPrice();
    Assert.assertEquals(priceFromItemPage, priceFromFirstPage, 0.001);
    Serenity.setSessionVariable(FIRST_ITEM_PRICE).to(priceFromFirstPage);
  }

  private double getPrice() {
    String priceInUsd = getUsdPrice();
    return Utility.convertStringPriceToDouble(priceInUsd);
  }

  private String getUsdPrice() {
    String firstPrice = getDriver().findElement(PRIMARY_PRICE).getText();
    String secondPrice = getDriver().findElement(SECONDARY_PRICE).getText();
    return Utility.chooseUsdPrice(firstPrice, secondPrice);
  }

  public void verifyShippingToCountry(String countryName) {
    getDriver().findElement(SHIPPING_TAB).click();
    WebElement webElement = getDriver().findElement(COUNTRY_DROPDOWN_MENU);
    List<WebElement> allCountriesFromList = Utility.getAllOptionsFromDropdown(webElement);
    Assert.assertTrue(allCountriesFromList.stream().anyMatch(option -> option.getText().equals(countryName)));
  }

  public void addToCart(int itemCount) {
    getDriver().findElement(QUANTITY).clear();
    getDriver().findElement(QUANTITY).sendKeys(String.valueOf(itemCount));
    getDriver().findElement(ADD_TO_CART_BUTTON).click();
    Serenity.setSessionVariable(ITEM_COUNT).to(itemCount);
  }
}