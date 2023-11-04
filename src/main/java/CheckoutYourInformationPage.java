import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends BasePage {
    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;


    public void inputFirstName(String firstNameValue) {
        firstNameInput.sendKeys(firstNameValue);
    }

    public void inputLastName(String lastNameValue) {
        lastNameInput.sendKeys(lastNameValue);
    }

    public void inputPostalCode(String postalCodeValue) {
        postalCodeInput.sendKeys(postalCodeValue);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public void checkoutYourInformation(CheckoutYourInformationPage checkoutYourInfoPage, String firstNameValue, String lastNameValue, String postalCodeValue) {
        inputFirstName(firstNameValue);
        inputLastName(lastNameValue);
        inputPostalCode(postalCodeValue);
        clickOnContinueButton();
    }
}
