package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import pages.MainPage;
import pages.ToysAndHobbiesPage;

public class MainPageSteps extends PageObject {

  private final MainPage mainPage = new MainPage();
  private final ToysAndHobbiesPage toysAndHobbiesPage = new ToysAndHobbiesPage();

  @Given("I navigate to eBay main page")
  public void navigateToEBayMainPage() {
    mainPage.openEbayPage();
  }

  @Then("I navigate to {string} page")
  public void navigateToPage(String menuName) {
    mainPage.shopByCategory(menuName);
    toysAndHobbiesPage.setToysAndHobbiesLoadPageElementToContext();
  }

}
