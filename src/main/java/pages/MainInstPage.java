package pages;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainInstPage extends BasePage {
    public MainInstPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[contains(text(),'Find People')]")
    private WebElement peopleSearchButton;

    @FindBy(xpath = Constants.XPATH_SEARCH_INPUT)
    private WebElement peopleSearchInput;


    public void clickOnPeopleSearchButton() {
        peopleSearchButton.click();
    }

    public void sendTextInPeopleSearchInput(String text) {
        peopleSearchInput.clear();
        peopleSearchInput.sendKeys(text);
    }
}
