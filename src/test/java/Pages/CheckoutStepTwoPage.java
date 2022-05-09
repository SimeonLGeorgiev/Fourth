package Pages;

import DTOmodels.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CheckoutStepTwoPage extends PageObject {

    public void verifyProductsInCart() {

        ArrayList<ItemDTO> listOfItemsInCart = new ArrayList<>();

        String inventoryItemPrice;
        List<WebElementFacade> itemNames = findAll(By.cssSelector("div[class='inventory_item_name']"));

        //Create list of items in cart
        for (int i = 0; i < itemNames.size(); i++) {
            List<WebElementFacade> itemPrices = findAll(By.cssSelector("div[class='inventory_item_price']"));
            inventoryItemPrice = itemPrices.get(i).getText();
            inventoryItemPrice = inventoryItemPrice.replaceAll("\\$", "");
            listOfItemsInCart.add(i, new ItemDTO(itemNames.get(i).getText(), Double.parseDouble(inventoryItemPrice)));
        }

        //Items from session will be called and compare with list of items in the card. All names and prices will be validated.
        ArrayList<ItemDTO> listOfPurchasedItems = Serenity.sessionVariableCalled("listOfPurchasedItems");
        Assert.assertEquals(listOfItemsInCart, listOfPurchasedItems);
    }

    public void verifyTotalAmount() {

        List<ItemDTO> listOfItems = Serenity.sessionVariableCalled("listOfPurchasedItems");
        WebElement totalAmountOnPageElement = find(By.cssSelector("div[class='summary_subtotal_label']"));
        double totalAmountOnPage;
//        totalAmountOnPageElement.getText().replaceAll("Item total: $", "");
        totalAmountOnPage = Double.parseDouble(totalAmountOnPageElement.getText().replaceAll("Item total: \\$", ""));

        double totalAmount = 0;

        for (ItemDTO listOfItem : listOfItems) {
            totalAmount = totalAmount + listOfItem.getPrice();
        }
        //Verify the amount in Cart is the same as expected
        Assert.assertEquals(totalAmount, totalAmountOnPage, 0.0);
        log.info("Price is verified!");
    }

    public void clickFinish() {
        WebElement finishButton = find(By.cssSelector("button[class='btn btn_action btn_medium cart_button']"));
        finishButton.click();
    }
}

