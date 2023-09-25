package com.vinsguru.test.flightreservation;

import com.vinsguru.pages.flightreservation.*;
import com.vinsguru.test.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends AbstractTest {

    private String noOfPassangers;
    private String expectedPrice;



    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setPageObjects(String noOfPassengers,String expectedPrice){
        this.noOfPassangers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void userRegistration(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCredentials("selenium@docker.com","docker");
        registrationPage.enterAddress("123 non main street","atlanta","30001");
        registrationPage.register();

    }

    @Test(dependsOnMethods ="userRegistration")
    public  void registrationConfirmationTest(){
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.goToFlightSearch();


    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        FlightSearchPage flightSearchPage=new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());
        flightSearchPage.selectPassengers(noOfPassangers);
        flightSearchPage.searchFlight();
    }


    @Test(dependsOnMethods = "flightSearchTest")
    public void  flightSelectionTest(){
        FlightsSelectionPage flightsSelectionPage=new FlightsSelectionPage(driver);
        Assert.assertTrue(flightsSelectionPage.isAt());
        flightsSelectionPage.selectFlights();
        flightsSelectionPage.confirmFlights();

    }


    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightReservationConfirmationTest(){
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        Assert.assertEquals(flightConfirmationPage.getPrice(),expectedPrice);

    }

}
