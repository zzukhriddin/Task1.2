package com.epam.esm.repository;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiftRepository {



    public static String data_source_url = "jdbc:postgresql://localhost:5432/epam1";
    public static String data_source_username = "postgres";
    public static String data_source_password = "root123";

    public List<GiftCertificate> getAll() throws SQLException, ClassNotFoundException {
        List<GiftCertificate> giftList = new ArrayList<>();
        Connection connection = connectDataBase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from gift order by id asc ");
        while (resultSet.next()){
            GiftCertificate gift = new GiftCertificate();
            gift.setId(resultSet.getLong(1));
            gift.setName(resultSet.getString(2));
            gift.setDescription(resultSet.getString(3));
            gift.setPrice(resultSet.getDouble(4));
            gift.setDuration(resultSet.getInt(5));
            gift.setCreate_date(resultSet.getTimestamp(6));
            gift.setLast_update_date(resultSet.getTimestamp(7));
            giftList.add(gift);
       }
        return giftList;
    }

    public ApiResponse save(GiftDto giftDto) {
        try {
            Connection connectDataBase = connectDataBase();
            String query = "insert into gift(name,description,price,duration,create_date,last_update_date) values('"+giftDto.getName()+
                    "','"+giftDto.getDescription()+
                    "',"+giftDto.getPrice()+
                    ","+giftDto.getDuration()+
                    ","+giftDto.getCreate_date()+
                    ","+giftDto.getLast_update_date()+");";
            Statement statement = connectDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet!=null){
                return new ApiResponse("successfully",true);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new ApiResponse("success",true);
    }

    public ApiResponse delete(Long id) {
        try {
            Connection connectDataBase = connectDataBase();
            String query = "delete from gift where id = "+id+";";
            Statement statement = connectDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet!=null){
                return new ApiResponse("deleted",true);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ApiResponse edit(Long id,GiftDto giftDto) {
        try {
            Connection connectDataBase = connectDataBase();
            String query = "update gift set name = '"+giftDto.getName()+"',description = '"+
                    giftDto.getDescription()+"',price = "+giftDto.getPrice()+",duration = "+
                    giftDto.getDuration()+",last_update_date = "+giftDto.getLast_update_date()+
                    "where id = "+id+";";
            Statement statement = connectDataBase.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet!=null){
                return new ApiResponse("updated",true);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return null;
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