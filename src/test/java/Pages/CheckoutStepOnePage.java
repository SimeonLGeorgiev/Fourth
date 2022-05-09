package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CheckoutStepOnePage extends PageObject {
  String firstName = "First Name";
  String lastName = "First Name";
  String zipCode = "12345";

  public void fillInformationAndContinue(){
    WebElement firstNameField = find(By.cssSelector("input[placeholder='First Name']"));
    WebElement lastNameField = find(By.cssSelector("input[placeholder='Last Name']"));
    WebElement zipCodeField = find(By.cssSelector("input[placeholder='Zip/Postal Code']"));
    WebElement continueButton = find(By.cssSelector("input[id='continue']"));

    firstNameField.sendKeys(firstName);
    lastNameField.sendKeys(lastName);
    zipCodeField.sendKeys(zipCode);
    continueButton.click();
  }
}

