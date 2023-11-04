import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PurchaseTest extends BaseTest{

    @Test
    public void successPurchase(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);
        
        //purchase
        inventoryPage.clickOnBackPackAddToCartButton();
        header.clickOnShoppingCartIcon();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckOutButton();

        CheckoutYourInformationPage checkoutYourInfoPage = new CheckoutYourInformationPage(driver);
        checkoutYourInfoPage.checkoutYourInformation(checkoutYourInfoPage, "Anna", "Smith", "1111");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.clickOnFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        assertTrue(checkoutCompletePage.thankYouTextIsDisplayed("Thank you for your order!"));


    }



    @Test
    public void checkFinalCost(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);

        inventoryPage.clickOnBackPackAddToCartButton(); // добавляю рюкзак в корзину
        inventoryPage.clickOnFleeceJacketAddToCartButton(); // добавляю флис.кофту в корзину
        inventoryPage.clickOnBikeLightAddToCartButton(); // добавляю вел.фонарь в корзину
        header.clickOnShoppingCartIcon(); // перехожу в корзину

        CartPage cartPage = new CartPage(driver);
        Double totalPriceFromCart = cartPage.calculatePrice();
        cartPage.clickOnCheckOutButton();

        CheckoutYourInformationPage checkoutYourInfoPage = new CheckoutYourInformationPage(driver);
        checkoutYourInfoPage.checkoutYourInformation(checkoutYourInfoPage, "Anna", "Smith", "1111");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        assertEquals(totalPriceFromCart, checkoutOverviewPage.getValue(), 0); // сравниваю цены из корзины и финальную стоимость

    }
}
