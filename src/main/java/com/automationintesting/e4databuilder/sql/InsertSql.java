package com.automationintesting.e4databuilder.sql;

import com.automationintesting.e4databuilder.model.BookingRequestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class InsertSql {

    private PreparedStatement preparedStatement;

    public InsertSql(Connection connection, BookingRequestModel booking) throws SQLException {
        String INSERT_SQL = "INSERT INTO PUBLIC.BOOKINGS(roomid, firstname, lastname, depositpaid, checkin, checkout) VALUES(?, ?, ?, ?, ?, ?);";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        preparedStatement = connection.prepareStatement(INSERT_SQL);

        preparedStatement.setInt(1, booking.getRoomid());
        preparedStatement.setString(2, booking.getFirstname());
        preparedStatement.setString(3, booking.getLastname());
        preparedStatement.setBoolean(4, booking.isDepositpaid());
        preparedStatement.setString(5, dateFormat.format(booking.getBookingdates().getCheckin()));
        preparedStatement.setString(6, dateFormat.format(booking.getBookingdates().getCheckout()));
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

}
