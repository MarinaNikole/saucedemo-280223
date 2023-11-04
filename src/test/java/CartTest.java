import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void successAdding1Item() {
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");
        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);

        inventoryPage.clickOnTShirtAddToCartButton();// переходим в корзину
        String tShirtPriceInventory = inventoryPage.getPriceOfTShirt(); // сохраняем цену в переменную
        header.clickOnShoppingCartIcon(); // переходим в корзину

        CartPage cartPage = new CartPage(driver);
        // assertTrue(cartPage.isTShirtPresent());
        assertEquals(1, cartPage.getItemsQuantity()); // проверяем, что 1 элемент корзине
        assertEquals(tShirtPriceInventory, cartPage.getPriceOfFirstItem()); // проверяем, что цена на InventoryPage соответствует цене в Корзине
    }

    @Test
    public void successAdding4Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);
        inventoryPage.clickOnBackPackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCartButton();
        inventoryPage.clickOnTShirtAddToCartButton();
        inventoryPage.clickOnFleeceJacketAddToCartButton();
        header.clickOnShoppingCartIcon();

        CartPage cartPage = new CartPage(driver);
        assertEquals(4, cartPage.getItemsQuantity());
    }

    @Test
    public void emptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        HeaderPage header = new HeaderPage(driver);
        header.clickOnShoppingCartIcon();

        CartPage cartPage = new CartPage(driver);
        // assertEquals(0, cartPage.getItemsQuantity());
        assertTrue(cartPage.cartIsEmpty());
    }

    @Test
    public void resetAppStateTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed()); // убеждаюсь, что мы находимся на InventoryPage

        inventoryPage.clickOnBackPackAddToCartButton(); // добавляю рюкзак в корзину
        inventoryPage.clickOnFleeceJacketAddToCartButton(); // добавляю флис.кофту в корзину
        inventoryPage.clickOnBikeLightAddToCartButton(); // добавляю вел.фонарь в корзину

        HeaderPage header = new HeaderPage(driver);
        header.clickOnShoppingCartIcon(); // перехожу в корзину

        CartPage cartPage = new CartPage(driver);
        assertTrue(!cartPage.cartIsEmpty()); // убеждаюсь, что корзина НЕ пустая

        header.clickOnBurgerMenu(); // перехожу в SideBar меню
        SideBarPage sideBarPage = new SideBarPage(driver);
        sideBarPage.clickOnResetAppLink(); // нажимаю на ResetAppLink (в методе заложила ожидание 4 секунды)

        header.clickOnShoppingCartIcon();
        assertTrue(cartPage.cartIsEmpty()); // убеждаюсь, что корзина пустая

    }

}
