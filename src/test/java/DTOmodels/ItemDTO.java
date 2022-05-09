package DTOmodels;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction;

import java.util.Objects;

public class ItemDTO extends PageObject {
    String name;
    double price;
    WebElement addToCart;

    public ItemDTO(String name, double price, WebElement addToCart) {
        this.name = name;
        this.price = price;
        this.addToCart = addToCart;
    }
    public ItemDTO(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "ItemDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Double.compare(itemDTO.price, price) == 0 && Objects.equals(name, itemDTO.name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(WebElement addToCart) {
        this.addToCart = addToCart;
    }
}
