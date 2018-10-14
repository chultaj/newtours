package com.demoaut.newtours.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryPurchase2 {

    WebDriver drv;

    @FindBy(css = "a[href='mercurysignoff.php']")
    WebElement logout;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")
    WebElement confirmation;


    public MercuryPurchase2(WebDriver drv) {
        this.drv = drv;
        PageFactory.initElements(drv, this);
    }

    public Welcome logut() {
        this.logout.click();
        return new Welcome(drv);
    }

    public boolean checkConfirmation(String text) {
        String a = confirmation.getText();
        return text.equals(confirmation.getText());
    }
}
