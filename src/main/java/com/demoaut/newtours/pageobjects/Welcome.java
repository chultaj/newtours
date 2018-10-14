package com.demoaut.newtours.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Welcome {

    WebDriver drv;

    @FindBy(name="userName")
    WebElement userName;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="login")
    WebElement SignIn;

    public Welcome(WebDriver drv) {
        this.drv = drv;
        PageFactory.initElements(drv, this);
    }

    public void sendUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void sendPassword(String password) {
        this.password.sendKeys(password);
    }

    public Reservation clickSignIn() {
        this.SignIn.click();
        return new Reservation(drv);
    }
}
