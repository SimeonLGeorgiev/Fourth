package pages;

import static enums.Keys.FIRST_ITEM_PRICE;
import static enums.Keys.LOADED_PAGE_ELEMENT;

import lombok.extern.log4j.Log4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@Log4j
public class ToysAndHobbiesPage extends PageObject {
  private static final By CATEGORY_DROPDOWN_ELEMENT = By.xpath("//select[@id=\"gh-cat\"]");
  private static final By SEARCH_FIELD = By.xpath("//input[@id=\"gh-ac\"]");
  private static final By SEARCH_BUTTON = By.xpath("//input[@id=\"gh-btn\"]");
  private static final String PRICE_OF_THE_FIRST_LISTED_ELEMENT =
      "//li[contains(@class, \"s-item\") and contains(@class, \"s-item__dsa-on-bottom\") and contains(@class,"
          + " \"s-item__pl-on-bottom\") and @data-view=\"mi:1686|iid:1\" and @data-gr4=\"2\" and @data-gr3=\"2\" "
          + "and @data-gr2=\"2\"]//span[@class='s-item__price']";
  private static final String SHIPPING_TO = "//span[@class='s-zipcode-entry__label' and text()='%s']";
  private static final String FIRST_ITEM = "%s/parent::*/parent::*/preceding-sibling::*[2]";

  public void setToysAndHobbiesLoadPageElementToContext() {
    Serenity.setSessionVariable(LOADED_PAGE_ELEMENT).to(CATEGORY_DROPDOWN_ELEMENT);
  }

  public void searchForItem(String itemName) {
    getDriver().findElement(SEARCH_FIELD).sendKeys(itemName);
    getDriver().findElement(SEARCH_BUTTON).click();
  }

  public void verifyShippingCountry(String countryName) {
    String shippingLocatorPath = String.format(SHIPPING_TO, countryName);
    getDriver().findElement(By.xpath(shippingLocatorPath)).isDisplayed();
  }

  public void verifyFirstElementHasPrice() {
    By priceOfTheFirstItem = By.xpath(PRICE_OF_THE_FIRST_LISTED_ELEMENT);
    getDriver().findElement(priceOfTheFirstItem).isDisplayed();
    String price = getDriver().findElement(priceOfTheFirstItem).getText();
    Serenity.setSessionVariable(FIRST_ITEM_PRICE).to(price);
  }

  public void navigateToFirstItem() {
    String firstItemLocatorPath = String.format(FIRST_ITEM, PRICE_OF_THE_FIRST_LISTED_ELEMENT);
    getDriver().findElement(By.xpath(firstItemLocatorPath)).click();
  }
}