import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SideBarPage extends BasePage{
    public SideBarPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(id = "logout_sidebar_link")
//    private WebElement logoutElement;



    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuLink;


    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemLink;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateLink;


    public void clickOnResetAppLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(resetAppStateLink));
        resetAppStateLink.click();
    }

    public void followTheLogOutLink(){
        assertTrue(logoutLink.isDisplayed());
        logoutLink.click();
    }


    public void clickOnBurgerMenuLink(){
        burgerMenuLink.click();
    }

    public boolean aboutLinkIsDisplayed() {
        return aboutLink.isDisplayed();
    }

    public boolean allItemLinkIsDisplayed() {
        return allItemLink.isDisplayed();
    }

    public boolean logoutLinkIsDisplayed() {
        return logoutLink.isDisplayed();
    }

    public boolean ResetAppStateLinkIsDisplayed() {
        return resetAppStateLink.isDisplayed();
    }

    public void clickOnResetAppState(){
        resetAppStateLink.click();
    }

}
