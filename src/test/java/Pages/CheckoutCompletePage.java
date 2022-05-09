package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CheckoutCompletePage extends PageObject {

  public void clickFinish(){
    WebElement finishButton = find(By.cssSelector("button[class='btn btn_primary btn_small']"));
    finishButton.click();
  }
}

