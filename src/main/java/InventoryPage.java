import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class=\"inventory_list\"]")
    private WebElement inventoryList;



    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;  // создаём список из всех товаров на странице

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames; // создаём список из названий товаров на странице




    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backPackAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTShirtAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacketAddToCartButton;


    @FindBy(xpath = "//div[@class=\"inventory_item\"][3]//div[@class=\"inventory_item_price\"]")
    private WebElement priceOfBoltTShirt;


    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css = "[value='az']")
    private WebElement nameAtoZ;

    @FindBy(css = "[value='za']")
    private WebElement nameZtoA;

    @FindBy(css = "[value='lohi']")
    private WebElement priceLowToHigh;

    @FindBy(css = "[value='hilo']")
    private WebElement priceHighToLow;
    @FindBy(css = "[class='inventory_item_price']")
    private List<WebElement> inventoryItemPrice;




//    public boolean realValue(int value){
//        return value > 0;
//    }

    public boolean inventoryListIsDisplayed() {
       return inventoryList.isDisplayed();
    }



    public int getItemsQuantity(){
        return inventoryItems.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item :inventoryItems) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allNamesArePresent() {
        boolean notEmpty = true;
        for (WebElement name : inventoryNames){
            if(name.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }


    public boolean allStartsWithSauceLabs(String text){
        boolean startsWith = true;
        for (WebElement itemName : inventoryNames){
            if(!itemName.getText().startsWith( text)){
                startsWith = false;
            }
        }
        return startsWith;
    }



    public void clickOnBackPackAddToCartButton() {
        backPackAddToCartButton.click();
    }

    public void clickOnTShirtAddToCartButton(){
        boltTShirtAddToCartButton.click();
    }

    public void clickOnBikeLightAddToCartButton(){
        bikeLightAddToCartButton.click();
    }
    public void clickOnFleeceJacketAddToCartButton(){
        fleeceJacketAddToCartButton.click();
    }

    public String getPriceOfTShirt() {
        return  priceOfBoltTShirt.getText();
    }

    public void clickSortByNameAtoZ(){
        sortDropdown.click();
        nameAtoZ.click();
    }


    public boolean checkNameSortAtoZ(){
        List<String> actualNames = new ArrayList<>();
        for(WebElement name : inventoryNames){
            actualNames.add(name.getText());
        }
       List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames);
        return actualNames.equals(expectedNames);
    }


    public void clickSortByNameZtoA(){
        sortDropdown.click();
        nameZtoA.click();
    }
    public boolean checkNameSortZtoA(){
        List<String> actualNames = new ArrayList<>();
        for(WebElement name : inventoryNames){
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(reverseOrder()); // сортируем в обратном порядке
        return actualNames.equals(expectedNames);
    }
    public void clickLowToHigh(){
        sortDropdown.click();
        priceLowToHigh.click();
    }


    public boolean checkPriceSortLowToHigh(){
        List<Double> actualPrice = new ArrayList<>();
        for(WebElement price : inventoryItemPrice){
            actualPrice.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        sort(expectedPrice);
        return actualPrice.equals(expectedPrice);
    }

    public void clickHighToLow(){
        sortDropdown.click();
        priceHighToLow.click();
    }

    public boolean checkPriceSortHighToLow(){
        List<Double> actualPrice = new ArrayList<>();
        for(WebElement price : inventoryItemPrice){
            actualPrice.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        expectedPrice.sort(reverseOrder());
        return actualPrice.equals(expectedPrice);
    }

}







//    public boolean allStartsWithSauceLabs(){
//        boolean startsWith = true;
//        for (WebElement itemName : inventoryNames){
//            if(!itemName.getText().startsWith( "Sauce Labs")){
//                startsWith = false;
//            }
//        }
//        return startsWith;
//    }



//    @FindBy(id = "logout_sidebar_link")
//    private WebElement logoutLink;
//    public void clickOnLogOutLink(){
//        logoutLink.click();
//    }
