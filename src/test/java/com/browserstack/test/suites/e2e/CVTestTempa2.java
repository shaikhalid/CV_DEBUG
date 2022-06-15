package com.browserstack.test.suites.e2e;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

public class CVTestTempa2 {
    private static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@hub-scale.browserstack.com/wd/hub";
    private static final String IP_STRING = "10.196.2.12";
    private WebDriver driver;
    DesiredCapabilities caps;
    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("project", "BrowserStack");
        caps.setCapability("build", "Demo");
        caps.setCapability("name", "Single Test - Chrome-US "+IP_STRING);
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("build", "Single_Windows-time-ana");
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("browserstack.machine", IP_STRING);
        driver = new RemoteWebDriver(new URL(URL), caps);
    }
    @Test
    public void testSearchBrowserStack() throws InterruptedException {
        driver.get("https://www.resume-library.com/jobs");
        Cookie DISABLE_DB_PROFILE = new Cookie("DISABLE_DB_PROFILE", "1");
        driver.manage().addCookie(DISABLE_DB_PROFILE);
        driver.getTitle();
        driver.get("https://www.resume-library.com/login");
        WebElement el1 = driver.findElement( By.cssSelector("#email"));
        el1.sendKeys("rainman21222@gmail.com");
        WebElement el2 = driver.findElement( By.cssSelector("#pass"));
        el2.sendKeys("2*WX3YvwqART_-r");
        WebElement el3 = driver.findElement( By.cssSelector("#signin\\-as\\-jobseeker"));
        if(el3.isEnabled()) {
            el3.click();
        }
        driver.get("https://www.resume-library.com/candidate/my-dashboard");
        WebElement el4 = driver.findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'My Dashboard')]"));
        el4.click();

        driver.get("https://www.resume-library.com/candidate/my-dashboard");
        WebElement el5 = driver.findElement( By.xpath("//h1[contains(text(),'My Dashboard')]"));
        el5.getText();

        WebElement el6 = driver.findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'My Profile')]"));
        el6.click();

        driver.get("https://www.resume-library.com/candidate/my-profile");
        WebElement el7 = driver.findElement( By.xpath("//h1[contains(text(),'My Profile')]"));
        el7.getText();

        WebElement el8 = driver.findElement( By.xpath("//*[@class='breadcrumbs']"));
        el8.getText();

        WebElement el9 = driver.findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'Job Alerts')]"));
        el9.click();

        driver.get("https://www.resume-library.com/candidate/my-profile");
        driver.get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        driver.get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        driver.get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        driver.get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        driver.get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        //String str = driver.getAttribute("value");
    }
    @AfterTest(alwaysRun = true)
    public void teardown() throws InterruptedException {
        driver.quit();
    } 
}