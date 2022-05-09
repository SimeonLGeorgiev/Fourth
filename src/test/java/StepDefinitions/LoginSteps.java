package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import Pages.SaucedemoLoginPage;

public class LoginSteps extends PageObject {

    SaucedemoLoginPage saucedemoLoginPage = new SaucedemoLoginPage();

    @Given("user is on login page")
    public void verifyHomepageIsLoaded() {
        saucedemoLoginPage.openPage();
        saucedemoLoginPage.checkPage();
    }


    @Then("{} has logged in {}")
    public void login(String user,String condition) {
        saucedemoLoginPage.logInPage(user);
        saucedemoLoginPage.verifySuccessfulLogin(condition);
    }

}
