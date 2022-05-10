package com.epam.esm;

import com.epam.esm.config.ApplicationConfig;
import com.epam.esm.service.GiftService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(new Timestamp(new Date().getTime()));

        ApplicationContext context  = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        GiftService giftService = context.getBean(GiftService.class);
    }
}