package com.browserstack.test.suites.e2e;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

public class BSDemo {
    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-euw.browserstack.com/wd/hub";
    private WebDriver driver;
    DesiredCapabilities caps;
    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("project", "BrowserStack");
        caps.setCapability("build", "Demo");
        caps.setCapability("name", "Single Test - Chrome");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("build", "Single_Windows-demo-US_UK");
        caps.setCapability("browserstack.machine","10.144.163.102");
        driver = new RemoteWebDriver(new URL(URL), caps);
    }
    @Test
    public void testSearchBrowserStack() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://bstackdemo.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin")));
        driver.findElement(By.id("signin")).click();
        driver.findElement(By.cssSelector("#username input")).sendKeys("demouser" + Keys.ENTER);
        driver.findElement(By.cssSelector("#password input")).sendKeys("testingisfun99" + Keys.ENTER);
        driver.findElement(By.id("login-btn")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        driver.findElement(By.cssSelector("div[id='1'] > div > button")).click();
        driver.findElement(By.id("favourites")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".spinner")));
        driver.findElement(By.className("Navbar_logo__26S5Y")).click();
        driver.findElement(By.id("orders")).click();
        wait.until(ExpectedConditions.urlContains("orders"));
        driver.findElement(By.className("Navbar_logo__26S5Y")).click();
        List<WebElement> imageSrc = driver.findElements(By.cssSelector(".shelf-item__thumb img"))
                .stream()
                .filter(image -> !image.getAttribute("src").equals(""))
                .collect(Collectors.toList());
        driver.findElement(By.className("Navbar_logo__26S5Y")).click();
        driver.findElement(By.cssSelector("input[value='Apple'] + span")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".products-found"), "9 Product(s) found."));
        driver.findElement(By.cssSelector("input[value='Samsung'] + span")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".products-found"), "16 Product(s) found."));
        List<String> values = driver.findElements(By.cssSelector(".shelf-item__title"))
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }
    @AfterTest(alwaysRun = true)
    public void teardown() {
        driver.get("https://fast.com");
        driver.quit();

    }
}