package com.vinsguru.pages.flightreservation;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {
    @FindBy(id="passengers")
    private WebElement passengerSelect;


    @FindBy(id="search-flights")
    private WebElement searchFlightButton;




    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {

        wait.until(ExpectedConditions.visibilityOf(passengerSelect));
        return passengerSelect.isDisplayed();
    }
    public void selectPassengers(String noOfPassengers) {
        Select passengers = new Select(passengerSelect);
        passengers.selectByValue(noOfPassengers);
    }
    public void searchFlight(){
        searchFlightButton.click();
    }



}
