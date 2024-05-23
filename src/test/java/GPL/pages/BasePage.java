package GPL.pages;

import GPL.utilities.DriverSetUp;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BasePage extends DriverSetUp {
    public  WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }
    public  void clickOnElement(By locator) {
        getElement(locator).click();
    }
    public void waitAndClick(By locator) {
        waitForElement(locator).click();
    }
    public WebElement waitForElement(By by) {
        return waitForElement(by, 50);
    }
    public WebElement waitForElement(By by, int seconds) {
        new FluentWait<>("")
                .withMessage(by.toString())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class)
                .until(driver -> getElement(by).isDisplayed());
        return getElement(by);
    }
    public void setTextByLocator(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }
    public  void setText(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).click();
        getElement(locator).sendKeys(text);
    }
    public  void scrollToElement() {
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 1800,
                "direction", "down",
                "percent", 9.0
        ));
    }
    public void takeScreenShot(String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) (getDriver())).getScreenshotAs(OutputType.BYTES)));
    }
//    public void scrollToElement01(String ele) {
//        String scrollableLocator = "new UiScrollable(new UiSelector().scrollable(true).instance(0))";
//        String elementLocator = String.format(".scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))", ele);
//        String fullLocator = scrollableLocator + elementLocator;
//
//        getDriver().findElement(AppiumBy.androidUIAutomator(fullLocator));
//    }
//    public String getElementText(By locator) {
//        return getElement(locator).getText();
//    }
//    public void selectItemByIndex(By locator, int index) {
//        WebElement element = getDriver().findElement(locator);
//        Select selectItems = new Select(element);
//        selectItems.selectByIndex(index);
//    }
//    public void selectItemByVisibleText(By locator, String value) {
//        WebElement element = getDriver().findElement(locator);
//        Select selectItems = new Select(element);
//        selectItems.selectByVisibleText(value);
//    }


}
