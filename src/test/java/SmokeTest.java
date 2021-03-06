import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainInstPage;
import services.Service;


public class SmokeTest extends BaseTest{



    @Test
    public void testInstagram() {

        Service.openUrl(Constants.INSTAGRAM_URL, driver);
//        logInPage.clickOnLogInHref();

//        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        Service.logIn(Constants.LOGIN, Constants.PASS, driver);

//        Service.simpleFollow("vicky_aisha", driver);

//        Service.searchPeopleByNickName("vicky_aisha", driver);


//        Service.likePeople(7,driver, wait);

        Service.closeNotificationWindow(driver);

        Service.moveToFollowingColumn(driver);

        Service.makeFollowingColumnToZero(driver, wait, 500);

    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

}
