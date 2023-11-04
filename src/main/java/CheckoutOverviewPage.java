import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Double.parseDouble;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;


    @FindBy(className = "summary_subtotal_label")
    private WebElement totalPrice;


    public void clickOnFinishButton() {
        finishButton.click();
    }

    public Double getValue(){
        return parseDouble(totalPrice.getText().substring(13));
      //    return parseDouble(itemTotal.getText().replace("Item total: $", "")); второй вариант
    }
}
