package com.epam.esm.repository;

import com.epam.esm.entity.GiftCertificate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class GiftCertificateRepositoryTest {

    @Autowired
    private GiftCertificateRepository giftCertificateRepository;

    @Test
    void getById() {
        GiftCertificate giftCertificate = new GiftCertificate(
                1L, "pen", "blue", 100.0, 2, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())
        );
    }

    @Test
    void getByName() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void edit() {
    }

    @Test
    void connectDataBase() {
    }
}
