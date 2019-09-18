package com.automationintesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RoomListingPage extends BasePage {

    @FindBy(how = How.CSS, using = "div[data-type~=\"room\"]")
    private List<WebElement> lstRooms;

    public RoomListingPage(WebDriver driver){
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-sm-2.rowHeader")));
    }

    public void clickFirstRoom() {
        lstRooms.get(0).click();
    }

}
