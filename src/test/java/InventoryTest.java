import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void inventoryItemsTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        assertEquals(6, inventoryPage.getItemsQuantity());

        assertTrue("Not all items are displayed", inventoryPage.allItemsAreDisplayed());

        //all items names are not empty
        assertTrue("Not all Names are displayed", inventoryPage.allNamesArePresent());

        //all items names starts with "Sauce Labs"
        assertTrue("Not all item Names starts with 'Sauce Labs' ", inventoryPage.allStartsWithSauceLabs("Sauce Labs"));

        sleep(5000);
    }

    @Test
    public void sortNameAtoZ() {
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickSortByNameAtoZ();
        assertTrue(inventoryPage.checkNameSortAtoZ());
    }

    @Test
    public void sortNameZtoA(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickSortByNameZtoA();
        assertTrue(inventoryPage.checkNameSortZtoA());
    }

    @Test
    public void sortLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickLowToHigh();
        assertTrue(inventoryPage.checkPriceSortLowToHigh());
    }


    @Test
    public void sortPriceHighToLow(){
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickHighToLow();
        assertTrue(inventoryPage.checkPriceSortHighToLow());
    }
}
