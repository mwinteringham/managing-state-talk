package com.automationintesting;

import com.automationintesting.e3databuilder.builder.BookingBuilder;
import com.automationintesting.e3databuilder.creators.BookingCreator;
import com.automationintesting.pageobjects.LoginPage;
import com.automationintesting.pageobjects.RoomListingPage;
import com.automationintesting.pageobjects.RoomPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleThreeTest {

    WebDriver driver;

    @Before
    public void SetUp(){
        driver = new DriverFactory().create();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void dataBuilderPatternApproach() throws InterruptedException {
        // Issues: Doesn't change the dogfooding

        BookingCreator.createBooking(new BookingBuilder().BuildOneWeekBooking());

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

        assertThat(latestBooking.getText(), is("Mark\nWinteringham\n133\ntrue\n2019-09-09\n2019-09-16"));
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
