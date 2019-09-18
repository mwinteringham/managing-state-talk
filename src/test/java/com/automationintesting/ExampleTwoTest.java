package com.automationintesting;

import com.automationintesting.pageobjects.LoginPage;
import com.automationintesting.pageobjects.RoomListingPage;
import com.automationintesting.pageobjects.RoomPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTwoTest {

    WebDriver driver;

    @Before
    public void SetUp(){
        driver = new DriverFactory().create();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void apiRequestApproach() throws InterruptedException {
        // Issues: Dogfooding, unmaintainable
        String myJson = "{\"bookingdates\":{\"checkin\":\"2019-09-10\",\"checkout\":\"2019-09-12\"},\"depositpaid\":false,\"firstname\":\"Mark\",\"lastname\":\"Winteringham\",\"roomid\":1,\"email\":\"mark@testemail.com\",\"phone\":\"01928129825\"}";

        given()
            .contentType(ContentType.JSON)
            .body(myJson)
            .post("http://localhost:8080/booking/");

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

        assertThat(latestBooking.getText(), is("Mark\nWinteringham\n38\nfalse\n2019-09-10\n2019-09-12"));
    }

    @After
    public void TearDown(){
        driver.quit();
    }

}
