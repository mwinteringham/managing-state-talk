package com.automationintesting.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RoomPage extends BasePage {

    @FindBy(how = How.CSS, using = ".detail")
    private List<WebElement> divBookings;

    public RoomPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLatestBooking() {
        return divBookings.get(divBookings.size() - 1);
    }
}
