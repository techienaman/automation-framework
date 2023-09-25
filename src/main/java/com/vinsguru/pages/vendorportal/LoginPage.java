package com.vinsguru.pages.vendorportal;

import com.vinsguru.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {


    @FindBy(id="username")
    private WebElement usernameInput;


    @FindBy(id="password")
    private WebElement passwordInput;


    @FindBy(id="login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isAt() {
       wait.until(ExpectedConditions.visibilityOf(loginButton));
       return loginButton.isDisplayed();
    }

public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
}

public void goTo(String url){
        driver.get(url);

}
}
