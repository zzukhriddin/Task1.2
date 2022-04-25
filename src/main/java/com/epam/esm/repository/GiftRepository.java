package com.epam.esm.repository;

import com.epam.esm.entity.Gift;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiftRepository {

    public static String data_source_url = "jdbc:postgresql://localhost:5432/computer_db";
    public static String data_source_username = "postgres";
    public static String data_source_password = "root123";

    public List<Gift> getAll() throws SQLException, ClassNotFoundException {
        List<Gift> giftList = new ArrayList<>();
        Connection connection = connectDataBase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from gift order by asc ");
        while (resultSet.next()){
            Gift gift = new Gift();
            gift.setId(resultSet.getLong(1));
            gift.setName(resultSet.getString(2));
            gift.setDescription(resultSet.getString(3));
            gift.setPrice(resultSet.getDouble(4));
            gift.setDuration(resultSet.getTimestamp(5));
            gift.setCreate_date(resultSet.getTimestamp(6));
            gift.setLast_update_date(resultSet.getTimestamp(7));
            giftList.add(gift);
       }
        return giftList;
    }

    public void save(GiftDto giftDto) {
    }

    public void delete(Long id) {
    }

    public void edit(Long id) {
    }

    public Connection connectDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                data_source_url,
                data_source_username,
                data_source_password
        );
        return connection;
    }
}