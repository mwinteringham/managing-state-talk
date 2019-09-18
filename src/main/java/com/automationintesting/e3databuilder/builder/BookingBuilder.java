package com.automationintesting.e3databuilder.builder;

import com.automationintesting.e3databuilder.model.BookingDatesModel;
import com.automationintesting.e3databuilder.model.BookingRequestModel;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingBuilder {

    public BookingRequestModel BuildOneWeekBooking() {
        Calendar startDate = new GregorianCalendar(2019, Calendar.SEPTEMBER, 10);
        Calendar endDate = new GregorianCalendar(2019, Calendar.SEPTEMBER, 17);

        BookingDatesModel bookingDatesModel = new BookingDatesModel(startDate.getTime(), endDate.getTime());
        return new BookingRequestModel(1, "Mark", "Winteringham", true, "mark@testemail.com", "01928129825", bookingDatesModel);
    }

    public BookingRequestModel BuildTwoDayBooking() {
        Calendar startDate = new GregorianCalendar(2019, Calendar.SEPTEMBER, 10);
        Calendar endDate = new GregorianCalendar(2019, Calendar.SEPTEMBER, 12);

        BookingDatesModel bookingDatesModel = new BookingDatesModel(startDate.getTime(), endDate.getTime());
        return new BookingRequestModel(1, "Mark", "Winteringham", true, "mark@testemail.com", "01928129825", bookingDatesModel);
    }
}
