package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(xpath = ".//a[contains(text(),'Log in')]")
    public WebElement logInHref;

    @FindBy(xpath = ".//button[contains(text(),'Log in')]")
    public WebElement logInButton;


    @FindBy(xpath = ".//input[@name='username']")
    public WebElement loginTextInput;

    @FindBy(xpath = ".//input[@name='password']")
    public WebElement passwordTextInput;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysIntoLoginField(String login) {
        loginTextInput.clear();
        loginTextInput.sendKeys(login);
    }


    public void sendKeysIntoPasswordField(String pass) {
        passwordTextInput.clear();
        passwordTextInput.sendKeys(pass);
    }

    public void clickOnLogInButton() {
        logInButton.click();
    }

    public void clickOnLogInHref() {
        logInHref.click();
    }

}
