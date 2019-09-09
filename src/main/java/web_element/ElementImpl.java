package web_element;

import logger.MainLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.List;
import java.util.logging.Logger;

public class ElementImpl {

    private final WebElement element;



    public ElementImpl(final WebElement element) {
        this.element = element;
    }


    public void click() {
        MainLogger.getLogger().info("click on \"" + element.getText() + "\" \"" + element.getTagName() + "\"");
        element.click();
    }

    public void submit() {
        element.submit();
    }


    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void clear() {
        element.clear();
    }

    public String getTagName() {
        return element.getTagName();
    }

    public String getAttribute(String s) {
        return element.getAttribute(s);
    }

    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }

    public String getText() {
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public Point getLocation() {
        return element.getLocation();
    }

    public Dimension getSize() {
        return element.getSize();
    }

    public Rectangle getRect() {
        return element.getRect();
    }

    public String getCssValue(String s) {
        return element.getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return element.getScreenshotAs(outputType);
    }

    public Coordinates getCoordinates() {
        return null;
    }

    public WebElement getWrappedElement() {
        return null;
    }



}
