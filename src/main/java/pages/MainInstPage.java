package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web_element.ElementImpl;

public class MainInstPage extends BasePage {
    public MainInstPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[contains(text(),'Not Now')]")
    private ElementImpl notNowNotificatonButton;

    @FindBy(xpath = ".//a[contains(text(),'Find People')]")
    private ElementImpl peopleSearchButton;

    @FindBy(xpath = Constants.XPATH_SEARCH_INPUT)
    private ElementImpl peopleSearchInput;

    @FindBy(xpath = ".//span[@aria-label='Profile']")
    private ElementImpl profileButton;

    @FindBy(xpath = ".//a[text()=' following']")
    private ElementImpl followingButton;

    @FindBy(xpath = ".//button[text()='Following']")
    private ElementImpl followingButton2;

    @FindBy(xpath = ".//button[text()='Unfollow']")
    private ElementImpl unfollowButton;

    public void clickOnNotNowNotificationButton(WebDriver driver) {

        if(driver.findElements(By.xpath(".//button[contains(text(),'Not Now')]")).size() != 0) {
            notNowNotificatonButton.click();
        }

    }

    public void clickUnfollowButton() {
        unfollowButton.click();
    }

    public void clickOnPeopleSearchButton() {
        peopleSearchButton.click();
    }

    public void clickProfileButton() {
        profileButton.click();
    }

    public void clickFollowingButton() {
        followingButton.click();
    }

    public void clickFollowing2Button() {
        followingButton2.click();
    }

    public void sendTextInPeopleSearchInput(String text) {
        peopleSearchInput.clear();
        peopleSearchInput.sendKeys(text);
    }

    public boolean isFollowingButtonDisplayed() {
        return followingButton2.isDisplayed();
    }

    public ElementImpl getFollowingButton() {
        return followingButton2;
    }
}
