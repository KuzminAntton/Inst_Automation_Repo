package driver_wrapper;

import com.google.common.collect.ImmutableMap;
import logger.MainLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ChromeDriverImpl extends ChromeDriver {

    public void sendKeys(String keysToSend) {
        MainLogger.getLogger().info("sending keys : " + keysToSend );
        if (keysToSend == null) {
            throw new IllegalArgumentException("Keys to send should be a not null CharSequence");
        } else {
            ChromeDriverImpl.this.execute("setAlertValue", ImmutableMap.of("text", keysToSend));
        }
    }




    public List<WebElement> findElements(By by) {
        return by.findElements(this);
    }

    public WebElement findElement(By by) {
        return by.findElement(this);
    }

    protected WebElement findElement(String by, String using) {
        MainLogger.getLogger().info("Searching element by " + by + " using " + using);
        if (using == null) {
            throw new IllegalArgumentException("Cannot find elements when the selector is null.");
        } else {
            Response response = this.execute("findElement", ImmutableMap.of("using", by, "value", using));
            Object value = response.getValue();

            WebElement element;
            try {
                element = (WebElement)value;
            } catch (ClassCastException var7) {
                throw new WebDriverException("Returned value cannot be converted to WebElement: " + value, var7);
            }

            this.setFoundBy(this, element, by, using);
            return element;
        }
    }


    protected List<WebElement> findElements(String by, String using) {
        MainLogger.getLogger().info("Searching element by " + by + " using " + using);
        if (using == null) {
            throw new IllegalArgumentException("Cannot find elements when the selector is null.");
        } else {
            Response response = this.execute("findElements", ImmutableMap.of("using", by, "value", using));
            Object value = response.getValue();
            if (value == null) {
                return Collections.emptyList();
            } else {
                List allElements;
                try {
                    allElements = (List)value;
                } catch (ClassCastException var8) {
                    throw new WebDriverException("Returned value cannot be converted to List<WebElement>: " + value, var8);
                }

                Iterator var6 = allElements.iterator();

                while(var6.hasNext()) {
                    WebElement element = (WebElement)var6.next();
                    this.setFoundBy(this, element, by, using);
                }

                return allElements;
            }
        }
    }

    public WebElement findElementById(String using) {
        return this.findElement("id", using);
    }

    public List<WebElement> findElementsById(String using) {
        return this.findElements("id", using);
    }

    public WebElement findElementByLinkText(String using) {
        return this.findElement("link text", using);
    }

    public List<WebElement> findElementsByLinkText(String using) {
        return this.findElements("link text", using);
    }

    public WebElement findElementByPartialLinkText(String using) {
        return this.findElement("partial link text", using);
    }

    public List<WebElement> findElementsByPartialLinkText(String using) {
        return this.findElements("partial link text", using);
    }

    public WebElement findElementByTagName(String using) {
        return this.findElement("tag name", using);
    }

    public List<WebElement> findElementsByTagName(String using) {
        return this.findElements("tag name", using);
    }

    public WebElement findElementByName(String using) {
        return this.findElement("name", using);
    }

    public List<WebElement> findElementsByName(String using) {
        return this.findElements("name", using);
    }

    public WebElement findElementByClassName(String using) {
        return this.findElement("class name", using);
    }

    public List<WebElement> findElementsByClassName(String using) {
        return this.findElements("class name", using);
    }

    public WebElement findElementByCssSelector(String using) {
        return this.findElement("css selector", using);
    }

    public List<WebElement> findElementsByCssSelector(String using) {
        return this.findElements("css selector", using);
    }

    public WebElement findElementByXPath(String using) {
        return this.findElement("xpath", using);
    }

    public List<WebElement> findElementsByXPath(String using) {
        return this.findElements("xpath", using);
    }

}
