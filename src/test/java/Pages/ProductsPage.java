package Pages;

import DTOmodels.ItemDTO;
import Utils.Utils;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.BooleanAssert;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductsPage extends PageObject {

    public void getAllItems() {

        ArrayList<ItemDTO> listOfItems = new ArrayList<>();

        String inventoryItemPrice;
        List<WebElementFacade> itemNames = findAll(By.cssSelector("div[class='inventory_item_name']"));
        //All items in the page will be added in List.
        for (int i = 0; i < itemNames.size(); i++) {
            List<WebElementFacade> itemPrices = findAll(By.cssSelector("div[class='inventory_item_price']"));
            List<WebElementFacade> addToCartButtons = findAll(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));
            inventoryItemPrice = itemPrices.get(i).getText();
            inventoryItemPrice = inventoryItemPrice.replaceAll("\\$", "");
            listOfItems.add(i, new ItemDTO(itemNames.get(i).getText(), Double.parseDouble(inventoryItemPrice), addToCartButtons.get(i)));

            // List with items will be saved in Session
            Serenity.setSessionVariable("listOfItems").to(listOfItems);
        }
    }

    public void addItemsToCart(int number) {
        WebElement shoppingCartIcon = find(By.cssSelector("a[class='shopping_cart_link']"));
        List<ItemDTO> listOfItems = Serenity.sessionVariableCalled("listOfItems");
        List<ItemDTO> listOfPurchasedItems = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            listOfItems.get(i).getAddToCart().click();
            listOfPurchasedItems.add(listOfItems.get(i));
        }
        // New list with purchased items is created and saved to Session
        Serenity.setSessionVariable("listOfPurchasedItems").to(listOfPurchasedItems);
        shoppingCartIcon.click();
    }

    public void addItemToCart(String itemName) {
        WebElement shoppingCartIcon = find(By.cssSelector("a[class='shopping_cart_link']"));

        List<ItemDTO> listOfItems = Serenity.sessionVariableCalled("listOfItems");
        List<ItemDTO> listOfPurchasedItems = new ArrayList<>();
        ItemDTO currentItem;
        //This will find item in list of all items
        currentItem = listOfItems.stream()
                .filter(itemDTO -> itemName.equals(itemDTO.getName()))
                .findAny()
                .orElse(null);

        assert currentItem != null;
        currentItem.getAddToCart().click();
        // New list with purchased items is created and saved to Session
        listOfPurchasedItems.add(currentItem);
        Serenity.setSessionVariable("listOfPurchasedItems").to(listOfPurchasedItems);
        shoppingCartIcon.click();
        log.info(itemName + " was added to cart!");
    }

    public void sortItems(String order) {
        Select orderDropdown = new Select(find(By.cssSelector("select[class='product_sort_container']")));
        orderDropdown.selectByVisibleText(order);
        log.info("The order is " + order);
    }

    public boolean verifyOrder(String order) {
        List<ItemDTO> listOfItems = Serenity.sessionVariableCalled("listOfItems");
        switch (order) {
            case "Name (A to Z)":
                if (Utils.isSortedAtoZ(listOfItems))
                    return true;
                break;
            case "Name (Z to A)":
                if (Utils.isSortedZtoA(listOfItems))
                    return true;
                break;
            case "Price (low to high)":
                if (Utils.isSorted1to9(listOfItems))
                    return true;
                break;
            case "Price (high to low)":
                if (Utils.isSorted9to1(listOfItems))
                    return true;
                break;
        }
        return false;
    }

}

