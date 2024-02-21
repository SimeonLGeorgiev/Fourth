package stepDefinitions;

import enums.Keys;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CommonSteps extends PageObject {

  @Then("I verify the page is loaded")
  public void verifyThePageIsLoaded() {
    By pageElement = Serenity.sessionVariableCalled(Keys.LOADED_PAGE_ELEMENT);
    getDriver().findElement(pageElement).isDisplayed();
  }
}
