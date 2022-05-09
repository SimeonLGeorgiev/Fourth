package StepDefinitions;

import DTOmodels.ItemDTO;
import Pages.*;
import Utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j

public class CheckoutSteps extends PageObject {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();
    CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Then("add items to cart and verify order")
    public void sortItems(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        data.forEach((item) -> {
                    productsPage.getAllItems();
                    productsPage.addItemToCart(item.get("item"));
                    cartPage.clickCheckout();
                    checkoutStepOnePage.fillInformationAndContinue();
                    checkoutStepTwoPage.verifyProductsInCart();
                    checkoutStepTwoPage.verifyTotalAmount();
                    checkoutStepTwoPage.clickFinish();
                    checkoutCompletePage.clickFinish();
                }
        );
    }

    @Then("add items {} to cart and verify order")
    public void addItemsToCart(int number) {

        productsPage.getAllItems();
        productsPage.addItemsToCart(number);
        cartPage.clickCheckout();
        checkoutStepOnePage.fillInformationAndContinue();
        checkoutStepTwoPage.verifyProductsInCart();
        checkoutStepTwoPage.verifyTotalAmount();
        checkoutStepTwoPage.clickFinish();
        checkoutCompletePage.clickFinish();
    }

}
