package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web_element.ElementImpl;

public class LogInPage extends BasePage{

    @FindBy(xpath = ".//a[contains(text(),'Log in')]")
    private ElementImpl logInHref;

    @FindBy(xpath = ".//button[@type='submit']")
    private ElementImpl logInButton;


    @FindBy(xpath = ".//input[@name='username']")
    private ElementImpl loginTextInput;

    @FindBy(xpath = ".//input[@name='password']")
    private ElementImpl passwordTextInput;


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
