package Helpers;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.ItemPage;

public class Utility {
  static final String US_$ = "US $";

  public static double convertStringPriceToDouble(String priceInUsd) {
    return Double.parseDouble(priceInUsd.replace(US_$, "")
        .replace("$", "")
        .replace("(", "")
        .replace(")", ""));
  }

  public static List<WebElement> getAllOptionsFromDropdown(WebElement webElement) {
    return webElement.findElements(By.tagName(ItemPage.OPTION));
  }

  public static String chooseUsdPrice(String firstPrice, String secondPrice) {
    return (firstPrice.contains(US_$)) ? firstPrice : secondPrice;
  }
}
