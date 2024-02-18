package Pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class SaucedemoLoginPage extends PageObject {
    private final String PAGE_URL = "https://www.saucedemo.com/";
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement inventoryContainer;
    private WebElement unsuccessfulMessage;


    public Users users = new Users();

    public void openPage() {
        getDriver().get(PAGE_URL);
        usernameField = find(By.id("user-name"));
        passwordField = find(By.id("password"));
        loginButton = find(By.id("login-button"));
    }

    public void checkPage() {
        usernameField.isDisplayed();
    }

    public void logInPage(String user) {
        usernameField.click();
        usernameField.sendKeys(users.getUsername(user));
        passwordField.click();
        passwordField.sendKeys(users.getPassword(user));
        loginButton.click();

    }

    public void verifySuccessfulLogin(String condition) {
        if (Objects.equals(condition, "successfully")) {
            inventoryContainer = find(By.id("inventory_container"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            inventoryContainer.isDisplayed();
        } else {
            unsuccessfulMessage = find(By.cssSelector("h3"));
            unsuccessfulMessage.isDisplayed();
        }

    }
}
