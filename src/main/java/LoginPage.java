import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) { // создаём конструктор
        super(driver); // PageFactory отвечает за инициализацию элементов на странице
    }

    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test=\"error\"]")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement swagLogoElement;

    @FindBy(id = "login_credentials")
    private WebElement usernamesBlock;

    @FindBy(className = "login_password")
    private WebElement passwordBlock;

//    @FindBy()
//    private WebElement;

    public void enterUsername(String usrenameValue) {
        usernameInputField.sendKeys(usrenameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessage.isDisplayed();
    }

//  Второй вариант написания теста, когда мы assertTrue кладём внутрь метода
//    public void errorMessageIsDisplayed(){
//    assertTrue(errorMessage.isDisplayed());
//  }

    public boolean errorMessageGetText(String expectedText) {
        return expectedText.equals(errorMessage.getText());
    }

    public boolean errorMessageContainsText(String expectedText) {
        return errorMessage.getText().contains(expectedText);
    }

    public boolean swagLogoIsDisplayed() {
        return swagLogoElement.isDisplayed();
    }

    public boolean userNameCredentialsIsDisplayed() {
        return usernamesBlock.isDisplayed();
    }

    public boolean passwordCredentialsIsDisplayed() {
        return passwordBlock.isDisplayed();
    }

    public boolean usernameIsDisplayed() {
        return usernameInputField.isDisplayed();
    }

    public void successLogin(String usernameValue, String passwordValue){
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickOnLoginButton();
    }
}
