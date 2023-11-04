import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkOutButton;

    @FindBy(className = "inventory_item_name")
    private WebElement itemTShirt;

    @FindBy (className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;



    public double calculatePrice(){
        double finalPrice = 0;
        for (WebElement item : itemPrices){
            finalPrice += Double.parseDouble(item.getText().substring(1));
        }
        return finalPrice;
    }


    public void clickOnCheckOutButton(){
        checkOutButton.click();
    }


    public int getItemsQuantity(){
        return cartItems.size();
    }

    public String getPriceOfFirstItem(){
        return itemPrices.get(0).getText();
    }

    public boolean cartIsEmpty(){
       boolean empty = false;
        try {
            WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(1));
            waite.until(ExpectedConditions.visibilityOf(cartItems.get(0)));
        } catch (Exception e) {
            empty = true;
        }
        return empty;
    }



}




//    public boolean isTShirtPresent(){
//        return itemTShirt.isDisplayed();
//    }


//    public String getPriceOfTShirt() {
//        return  priceOfBoltTshirt.getText();
//    }

//    @FindBy(xpath = "//div[text() = \"15.99\"]")
//    private WebElement priceOfBoltTshirt;