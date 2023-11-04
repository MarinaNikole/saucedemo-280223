import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void allLinksAreDisplayed(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        SideBarPage sidebar = new SideBarPage(driver);
        sidebar.clickOnBurgerMenuLink();
        assertTrue(sidebar.allItemLinkIsDisplayed());
        assertTrue(sidebar.aboutLinkIsDisplayed());
        assertTrue(sidebar.logoutLinkIsDisplayed());
        assertTrue(sidebar.ResetAppStateLinkIsDisplayed());

    }

    @Test
    public void resetAppState(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);


        inventoryPage.clickOnBackPackAddToCartButton(); // добавляю рюкзак в корзину
        inventoryPage.clickOnFleeceJacketAddToCartButton(); // добавляю флис.кофту в корзину
        inventoryPage.clickOnBikeLightAddToCartButton(); // добавляю вел.фонарь в корзину

        int valueFromCartBadge = header.getValueFromCartBadge();
        assertEquals(3, valueFromCartBadge);

        SideBarPage sideBarPage = new SideBarPage(driver);
        sideBarPage.clickOnBurgerMenuLink();
        sideBarPage.clickOnResetAppLink();

//        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(cartBadge);

//       // int nullValue = header.getValueFromCartBadge();

       // assertEquals(0, valueFromCartBadge);






    }
}
