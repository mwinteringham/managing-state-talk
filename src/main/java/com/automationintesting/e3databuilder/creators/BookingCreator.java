package com.automationintesting.e3databuilder.creators;

import com.automationintesting.e3databuilder.model.BookingRequestModel;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BookingCreator {

    public static void createBooking(BookingRequestModel bookingPayload) {
        given()
            .contentType(ContentType.JSON)
            .body(bookingPayload)
            .post("http://localhost:8080/booking/");
    }
}
