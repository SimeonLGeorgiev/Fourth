package StepDefinitions;

import Pages.*;
import Utils.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class ItemOrderSteps extends PageObject {

    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();
    CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();
    CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Then("sort items by order dropdown and verify order")
    public void sortItems(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        SoftAssertions softAssertions = new SoftAssertions();

        data.forEach((item) -> {
                    productsPage.sortItems(item.get("order"));
                    productsPage.getAllItems();
                    softAssertions.assertThat(
                            productsPage.verifyOrder(item.get("order"))).isEqualTo(true);

                }
        );
        softAssertions.assertAll();
    }
}
