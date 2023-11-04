import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;

public class HeaderPage extends BasePage{
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;

    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingCartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;


//    public int getCartBadgeQantity(){
//        return parseInt()
//    }
    public int getValueFromCartBadge(){
        return parseInt(cartBadge.getText());
    }

    public void clickOnBurgerMenu() {
        assertTrue(burgerMenu.isDisplayed());
        burgerMenu.click();
    }


    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }

}

