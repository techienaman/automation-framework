package com.vinsguru.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {


    protected WebDriver driver;



    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        if(Boolean.getBoolean("selenium.grid.enabled")){
            this.driver= getRemoteWebDriver();
        }
        else{
            driver=getLocalDriver();
        }
    }


    public WebDriver getRemoteWebDriver() throws MalformedURLException {
        Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome")){
            capabilities=new ChromeOptions();
        }
        else{
            capabilities=new FirefoxOptions();
        }
        return new RemoteWebDriver(new URL("http://192.168.29.200:4444/wd/hub"),capabilities);

    }

    public WebDriver getLocalDriver(){
        WebDriverManager.chromedriver().setup();
        return this.driver=new ChromeDriver();

    }


    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}
