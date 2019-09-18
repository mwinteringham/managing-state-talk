package com.automationintesting.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = ".openBooking")
    private WebElement btnOpenBooking;

    @FindBy(how = How.CSS, using = ".btn-outline-primary.book-room")
    private WebElement btnSubmitBooking;

    @FindBy(how = How.CSS, using = ".alert-danger")
    private WebElement divAlert;

    @FindBy(how = How.CSS, using = ".room-firstname")
    private WebElement inptBookingFormFirstName;

    @FindBy(how = How.CSS, using = ".room-lastname")
    private WebElement inptBookingFormLastName;

    @FindBy(how = How.CSS, using = ".room-email")
    private WebElement inptBookingFormEmail;

    @FindBy(how = How.CSS, using = ".room-phone")
    private WebElement inptBookingFormPhone;

    @FindBy(how = How.CSS, using = ".rbc-month-view .rbc-row-bg .rbc-day-bg:nth-child(2)")
    private WebElement divDateBox;

    public HomePage(WebDriver driver) {
        super(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".openBooking")));
    }

    public void clickOpenBookingForm() {
        btnOpenBooking.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rbc-calendar")));
    }

    public void clickSubmitBooking() {
        btnSubmitBooking.click();
    }


    public Boolean bookingFormErrorsExist() {
        return divAlert.isDisplayed();
    }

    public void setBookingFormFirstName(String firstname) {
        inptBookingFormFirstName.sendKeys(firstname);
    }

    public void setBookingFormLastName(String lastname) {
        inptBookingFormLastName.sendKeys(lastname);
    }


    public void setBookingFormEmail(String email) {
        inptBookingFormEmail.sendKeys(email);
    }

    public void setBookingFormPhone(String phone) {
        inptBookingFormPhone.sendKeys(phone);
    }

    public WebElement getDateElement() {
        return divDateBox;
    }
}
