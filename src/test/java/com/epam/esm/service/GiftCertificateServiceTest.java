package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.repository.GiftCertificateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GiftCertificateServiceTest {

    @Autowired
    GiftCertificateService giftCertificateService;

    @Mock
    private GiftCertificateRepository giftCertificateRepository;

    static final long TEST_GIFT_ID=1;

    @Test
    void getGiftCertificateById() throws SQLException, ClassNotFoundException {
        Assertions.assertTrue(giftCertificateService.getGiftCertificateById(TEST_GIFT_ID).getId()==1);
    }

    @Test
    void getAllGiftCertificate() throws SQLException, ClassNotFoundException {
        List<GiftCertificate> list = new ArrayList<>();
        list.add(new GiftCertificate());
        given(giftCertificateRepository);
        List<GiftCertificate> expected = giftCertificateService.getAllGiftCertificate();
        assertEquals(expected, list);
        verify(giftCertificateRepository);    }

    @Test
    void editGiftCertificate() {
        GiftCertificate giftCertificate1 = new GiftCertificate();
        giftCertificate1.setId(3l);
        giftCertificate1.setName("pen");
        GiftCertificate newGiftCertificate = new GiftCertificate();
        newGiftCertificate.setName("test name");
        given(giftCertificateRepository);

    }
}