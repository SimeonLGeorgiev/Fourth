package stepDefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import pages.ItemPage;
import pages.ToysAndHobbiesPage;

public class ToysAndHobbiesPageSteps extends PageObject {

  private final ToysAndHobbiesPage toysAndHobbies = new ToysAndHobbiesPage();
  private final ItemPage itemPage = new ItemPage();


  @Then("I verify {string} page is open and search for {word}")
  public void verifyPageIsOpenAndSearchForMonopoly(String menuName, String itemName) {
    toysAndHobbies.searchForItem(itemName);
  }

  @Then("I verify the item has shipping to {word} and the Price is visible")
  public void verifyTheItemHasShippingToBulgariaAndThePrice(String countryName) {
    toysAndHobbies.verifyShippingCountry(countryName);
    toysAndHobbies.verifyFirstElementHasPrice();
  }


  @Then("I navigate to first item of the list")
  public void navigateToFirstItemOfTheList() {
    toysAndHobbies.navigateToFirstItem();
    itemPage.setItemPageElementToContext();
  }
}
