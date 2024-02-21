package pages;

import static enums.Keys.LOADED_PAGE_ELEMENT;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MainPage extends PageObject {
  private static final String PAGE_URL = "https://www.ebay.com/";
  private static final By LOGO_ELEMENT = By.xpath("//img[@alt='eBay Home']");
  private static final By SHOP_BY_CATEGORY_BY_ELEMENT = By.xpath("//button[@id='gh-shop-a']");
  private static final String CATEGORIES_ELEMENT = "//h3[@class='gh-sbc-parent']/a[contains(text(), '%s')]";

  public void openEbayPage() {
    getDriver().get(PAGE_URL);
    Serenity.setSessionVariable(LOADED_PAGE_ELEMENT).to(LOGO_ELEMENT);
  }

  public void shopByCategory(String menuName) {
    getDriver().findElement(SHOP_BY_CATEGORY_BY_ELEMENT).click();
    getDriver().findElement(By.xpath(String.format(CATEGORIES_ELEMENT, menuName))).click();
  }
}