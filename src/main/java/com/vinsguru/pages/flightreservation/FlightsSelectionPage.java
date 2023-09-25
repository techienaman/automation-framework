package com.vinsguru.pages.flightreservation;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightsSelectionPage extends AbstractPage {


    @FindBy(name="arrival-flight")
    private List<WebElement>  arrivalFlightsOptions;

    @FindBy(name="departure-flight")
    private List<WebElement>  departureFlightsOptions;

    @FindBy(id="confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightsSelectionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
     wait.until(ExpectedConditions.visibilityOf(confirmFlightsButton));
     return confirmFlightsButton.isDisplayed();
    }



    public void confirmFlights(){
        confirmFlightsButton.click();
    }

    public void selectFlights(){
        int random= ThreadLocalRandom.current().nextInt(0,9);
        departureFlightsOptions.get(random).click();
        arrivalFlightsOptions.get(random).click();
    }




}
