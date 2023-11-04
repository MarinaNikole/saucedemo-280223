import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
   private WebElement thankYouText;

    public boolean thankYouTextIsDisplayed(String expectedText){
       return thankYouText.getText().contains(expectedText);
    }
}
