package com.vinsguru.test.vendorportal;

import com.vinsguru.pages.vendorportal.DashboardPage;
import com.vinsguru.pages.vendorportal.LoginPage;
import com.vinsguru.test.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;



    @BeforeTest
    public void setPageObjects(){
         loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
    }
    @Test
    public void  loginTest(){

        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login("sam","sam");
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest(){
        Assert.assertTrue(dashboardPage.isAt());
        Assert.assertEquals(dashboardPage.getMonthlyEarning(),"$40,000");
        Assert.assertEquals(dashboardPage.getAnnualEarning(),"$215,000");
        Assert.assertEquals(dashboardPage.getProfitMargin(),"50%");
        dashboardPage.searchOrderHistoryBy("adams");


    }


    @Test(dependsOnMethods="dashboardTest")
    public void logout(){
        dashboardPage.logout();

    }


    public void quitDriver(){
        driver.quit();
    }
}
