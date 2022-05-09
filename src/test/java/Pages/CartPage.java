package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CartPage extends PageObject {

  public void clickCheckout(){
    WebElement checkoutButton = find(By.cssSelector("button[class='btn btn_action btn_medium checkout_button']"));
    checkoutButton.click();
  }
}

