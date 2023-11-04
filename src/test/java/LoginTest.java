import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class LoginTest extends BaseTest {


    @Test
    public void successLoginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        assertTrue("Inventory list should NOT be visible", inventoryPage.inventoryListIsDisplayed());

        // WebElement userName = driver.findElement(By.id("user-name"));
        // userName.sendKeys("standard_user");

        // WebElement password = driver.findElement(By.id("password"));
        //  password.sendKeys("secret_sauce");

        //   WebElement loginButton = driver.findElement(By.id("login-button"));
        //   loginButton.click();

        //  WebElement inventoryList = driver.findElement(By.cssSelector("[class=\"inventory_list\"]"));
        //  assertTrue(inventoryList.isDisplayed());
    }

    @Test
    public void invalidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret");
        loginPage.clickOnLoginButton();

        assertTrue(loginPage.errorMessageIsDisplayed());
        assertTrue(loginPage.errorMessageGetText("Epic sadface: Username and password do not match any user in this service"));
        assertTrue(loginPage.errorMessageContainsText("Username and password do not match any user in this service"));

        //  WebElement userName = driver.findElement(By.id("user-name"));
        //  userName.sendKeys("standard_user");

        //   WebElement password = driver.findElement(By.id("password"));
        //   password.sendKeys("secret");

        //  WebElement loginButton = driver.findElement(By.id("login-button"));
        //  loginButton.click();

        //  WebElement errorMessage = driver.findElement(By.cssSelector("[data-test=\"error\"]"));

        // assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage.getText());
        //  assertTrue(errorMessage.isDisplayed());
        // assertTrue(errorMessage.getText().contains("Username and password do not match any user in this service"));
    }

    @Test
    public void lockedOutUserTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        assertTrue(loginPage.errorMessageIsDisplayed());
        assertTrue(loginPage.errorMessageGetText("Epic sadface: Sorry, this user has been locked out."));
        assertTrue(loginPage.errorMessageContainsText("Sorry, this user has been locked out."));
    }

    @Test
    public void invalidUserNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin("testUser","secret_sauce");
        loginPage.clickOnLoginButton();

        assertTrue(loginPage.errorMessageIsDisplayed());
        assertTrue(loginPage.errorMessageGetText("Epic sadface: Username and password do not match any user in this service"));
        assertTrue(loginPage.errorMessageContainsText("Username and password do not match any user in this service"));
    }

    @Test
    public void elementsAreDisplayedTest()  {
        LoginPage loginPage = new LoginPage(driver);
         assertTrue(loginPage.swagLogoIsDisplayed());

        assertTrue(loginPage.userNameCredentialsIsDisplayed());

        assertTrue(loginPage.passwordCredentialsIsDisplayed());

    }

    @Test
    public void successLogOutTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);  //создаём экземпляр класса LoginPage
        loginPage.successLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver); //создаём экземпляр класса InventoryPage
        HeaderPage header = new HeaderPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        header.clickOnBurgerMenu();

        //follow the Logout link of sidebar
        SideBarPage sideBar= new SideBarPage(driver);
        sideBar.followTheLogOutLink();

        //check that logout is successful
        assertTrue(loginPage.usernameIsDisplayed());

//        inventoryPage.clickOnLogOutLink();


        sleep(5000);

    }
}
