package pages;

import decorator.CustomFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(final WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }
}
