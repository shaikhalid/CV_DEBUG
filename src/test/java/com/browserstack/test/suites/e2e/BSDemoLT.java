package com.browserstack.test.suites.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class BSDemoLT {
    private static final String USERNAME = "khalidstewards";
    private static final String ACCESS_KEY = "X6hVXSVBrnNtSn9Wm27YwzQsCf8tyQGTGtRo6b9kL8SYuMGz8o";
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub.lambdatest.com/wd/hub";
    private WebDriver driver;
    DesiredCapabilities caps;
    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("project", "BrowserStack");
        caps.setCapability("build", "Demo");
        caps.setCapability("name", "Single Test - Chrome");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "100");
        caps.setCapability("build", "Single_LT");
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
        driver.quit();
    }
}