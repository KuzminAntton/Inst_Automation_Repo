package services;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;
import pages.MainInstPage;
import java.util.concurrent.TimeUnit;

public class Service {

    public static void logIn(String login, String pass, WebDriver driver) {
        LogInPage logInPage = new LogInPage(driver);

        logInPage.sendKeysIntoLoginField(login);

        logInPage.sendKeysIntoPasswordField(pass);

        logInPage.clickOnLogInButton();
    }

    public static void openUrl(String url, WebDriver driver) {
        driver.navigate().to(url);
    }

    public static void followPeople(int peopleQuantity, WebDriver driver, WebDriverWait wait) {
        openFirstPhoto(driver);
        try {
            for(int i = 0; i < peopleQuantity; i++) {

                if(driver.findElements(By.xpath(Constants.XPATH_FOLLOW_BUTTON)).size() > 0) {
                    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_FOLLOW_BUTTON)));
                    driver.findElement(By.xpath(Constants.XPATH_FOLLOW_BUTTON)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_FOLLOWING_BUTTON)));
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_FOLLOWING_BUTTON)));
                    i--;
                }
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_NEXT_PHOTO_BUTTON)));
                driver.findElement(By.xpath(Constants.XPATH_NEXT_PHOTO_BUTTON)).click();
            }
        } catch (TimeoutException e) {
            followPeople(50, driver, wait);
        }

    }

    public static void likePeople(int peopleQuantity, WebDriver driver, WebDriverWait wait) {
        openFirstPhoto(driver);

        try {
            for(int i = 0; i < peopleQuantity; i++) {

                if(driver.findElements(By.xpath(Constants.XPATH_LIKE_BUTTON)).size() > 0) {
                    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_LIKE_BUTTON)));

                    driver.findElement(By.xpath(Constants.XPATH_LIKE_BUTTON)).click();

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_UNLIKE_BUTTON)));
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_UNLIKE_BUTTON)));
                    i--;
                }
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.XPATH_NEXT_PHOTO_BUTTON)));
                driver.findElement(By.xpath(Constants.XPATH_NEXT_PHOTO_BUTTON)).click();
            }
        } catch (TimeoutException e) {
            likePeople(50, driver, wait);
        }

    }

    public static void searchPeopleByNickName(String nickName, WebDriver driver) {
        MainInstPage mainInstPage = new MainInstPage(driver);
        mainInstPage.sendTextInPeopleSearchInput(nickName);
        String nameXpath = ".//a[@href='/%s/']//span[contains(text(), '%s')]";
        nameXpath = String.format(nameXpath, nickName, nickName);
        driver.findElement(By.xpath(nameXpath)).click();
    }

    public static void simpleFollow(String nickName, WebDriver driver) {
        searchPeopleByNickName(nickName, driver);
        if(driver.findElement(By.xpath(Constants.XPATH_FOLLOW_BUTTON)).isDisplayed()) {
            driver.findElement(By.xpath(Constants.XPATH_FOLLOW_BUTTON)).click();
        }
    }

    public static void simpleLike(String nickName, WebDriver driver) {
        searchPeopleByNickName(nickName, driver);
        if(driver.findElement(By.xpath(Constants.XPATH_UNLIKE_BUTTON)).isDisplayed()) {
            driver.findElement(By.xpath(Constants.XPATH_LIKE_BUTTON)).click();
        }

    }

    public static void openFirstPhoto(WebDriver driver) {
        WebElement img = driver.findElement(By.xpath(".//img[@sizes='293px']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(img).click().build().perform();
    }

}
