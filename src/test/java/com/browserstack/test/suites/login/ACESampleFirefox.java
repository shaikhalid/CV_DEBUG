package com.browserstack.test.suites.login;

import com.browserstack.test.suites.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ACESampleFirefox extends TestBase {

    @Test
    public void loginLockedUser() {
        // getDriver().manage().window().maximize();
        // getDriver().manage().timeouts().pageLoadTimeout( java.time.Duration.ofSeconds(60));
        // getDriver().manage().timeouts().implicitlyWait( java.time.Duration.ofSeconds(20));
        // getDriver().manage().deleteAllCookies();
        getDriver().get("https://www.resume-library.com/jobs");
        Cookie DISABLE_DB_PROFILE = new Cookie("DISABLE_DB_PROFILE", "1");
        getDriver().manage().addCookie(DISABLE_DB_PROFILE);
        getDriver().getTitle();
        getDriver().get("https://www.resume-library.com/login");
        WebElement el1 = getDriver().findElement( By.cssSelector("#email"));
        el1.sendKeys("rainman21222@gmail.com");
        WebElement el2 = getDriver().findElement( By.cssSelector("#pass"));
        el2.sendKeys("2*WX3YvwqART_-r");
        WebElement el3 = getDriver().findElement( By.cssSelector("#signin\\-as\\-jobseeker"));
        if(el3.isEnabled()) {
            el3.click();
        }
        getDriver().get("https://www.resume-library.com/candidate/my-dashboard");
        WebElement el4 = getDriver().findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'My Dashboard')]"));
        el4.click();

        getDriver().get("https://www.resume-library.com/candidate/my-dashboard");
        WebElement el5 = getDriver().findElement( By.xpath("//h1[contains(text(),'My Dashboard')]"));
        el5.getText();

        WebElement el6 = getDriver().findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'My Profile')]"));
        el6.click();

        getDriver().get("https://www.resume-library.com/candidate/my-profile");
        WebElement el7 = getDriver().findElement( By.xpath("//h1[contains(text(),'My Profile')]"));
        el7.getText();

        WebElement el8 = getDriver().findElement( By.xpath("//*[@class='breadcrumbs']"));
        el8.getText();

        WebElement el9 = getDriver().findElement( By.xpath("//nav[@label=\"Site Navigation\"]/ul/li/a[contains(text(),'Job Alerts')]"));
        el9.click();

        getDriver().get("https://www.resume-library.com/candidate/my-profile");
        getDriver().get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        getDriver().get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        getDriver().get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        getDriver().get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
        getDriver().get("https://reader-bookshelf.savvasrealizedev.com/bookshelf");
    }

}
