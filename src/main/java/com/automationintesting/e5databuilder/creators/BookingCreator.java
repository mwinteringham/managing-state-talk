package com.automationintesting.e5databuilder.creators;

import com.automationintesting.e5databuilder.model.BookingRequestModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.text.SimpleDateFormat;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class BookingCreator {

    public static void createBooking(BookingRequestModel bookingPayload) {
        String queryResult = queryBooking(bookingPayload);

        if(queryResult == null){
            insertBooking(bookingPayload);
        }
    }

    private static String queryBooking(BookingRequestModel bookingPayload) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Response response = given()
                                .param("roomid", bookingPayload.getRoomid())
                                .param("firstname", bookingPayload.getFirstname())
                                .param("lastname", bookingPayload.getLastname())
                                .param("depositpaid", bookingPayload.isDepositpaid())
                                .param("email", bookingPayload.isDepositpaid())
                                .param("phone", bookingPayload.isDepositpaid())
                                .param("checkin", sdf.format(bookingPayload.getBookingdates().getCheckin()))
                                .param("checkout", sdf.format(bookingPayload.getBookingdates().getCheckout()))
                                .post("http://localhost:8081/booking/query");

        return from(response.getBody().prettyPrint()).getString("results[0].FIRSTNAME");
    }

    private static void insertBooking(BookingRequestModel bookingPayload){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        given()
            .param("roomid", bookingPayload.getRoomid())
            .param("firstname", bookingPayload.getFirstname())
            .param("lastname", bookingPayload.getLastname())
            .param("depositpaid", bookingPayload.isDepositpaid())
            .param("email", bookingPayload.isDepositpaid())
            .param("phone", bookingPayload.isDepositpaid())
            .param("checkin", sdf.format(bookingPayload.getBookingdates().getCheckin()))
            .param("checkout", sdf.format(bookingPayload.getBookingdates().getCheckout()))
            .post("http://localhost:8081/booking");
    }
}
