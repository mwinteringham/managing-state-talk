package com.automationintesting;

import com.automationintesting.pageobjects.HomePage;
import com.automationintesting.pageobjects.LoginPage;
import com.automationintesting.pageobjects.RoomListingPage;
import com.automationintesting.pageobjects.RoomPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleOneTest {

    WebDriver driver;

    @Before
    public void SetUp(){
        driver = new DriverFactory().create();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void uiDrivenApproach() throws InterruptedException {
        // Issues: Slow, Insensitive to context
        driver.navigate().to("http://localhost:8080/#/");

        HomePage homePage = new HomePage(driver);
        homePage.clickOpenBookingForm();

        WebElement dateElement = homePage.getDateElement();

        Actions actions = new Actions(driver);
        actions.clickAndHold(dateElement)
                .moveByOffset(20,10)
                .pause(1000)
                .moveByOffset(100,0)
                .pause(1000)
                .release()
                .build()
                .perform();

        homePage.setBookingFormFirstName("Mark");
        homePage.setBookingFormLastName("Winteringham");
        homePage.setBookingFormEmail("mark@testemail.com");
        homePage.setBookingFormPhone("01928129825");
        homePage.clickSubmitBooking();

        Thread.sleep(1000); // Added for demo purposes

        driver.navigate().to("http://localhost:8080/#/admin");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername("admin");
        loginPage.populatePassword("password");
        loginPage.clickLogin();

        Thread.sleep(1000); // Added for demo purposes

        RoomListingPage roomListingPage = new RoomListingPage(driver);
        roomListingPage.clickFirstRoom();

        RoomPage roomPage = new RoomPage(driver);
        WebElement latestBooking = roomPage.getLatestBooking();

        Thread.sleep(1000); // Added for demo purposes

        assertThat(latestBooking.getText(), is("Mark\nWinteringham\n19\nfalse\n2019-09-02\n2019-09-03"));
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
