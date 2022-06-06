//package com.epam.esm.repository;
//
//import com.epam.esm.entity.GiftCertificate;
//import org.assertj.core.api.Assertions;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.postgresql.ds.PGPooledConnection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class GiftCertificateRepositoryTest {
//
//    @Autowired
//    private GiftCertificateRepository giftCertificateRepository;
//    private PGPooledConnection SybaseDBConnection;
//
//    @Test
//    void getByIdGiftCertificateTest() {
//        GiftCertificate giftCertificate = giftCertificateRepository.findById(1);
//        Assertions.assertThat(giftCertificate.getId()).isEqualTo(1);
//    }
//
//    @Test
//    void getByNameGiftCertificateTest() {
//        GiftCertificate giftCertificate = giftCertificateRepository.findByName("book");
//        Assertions.assertThat(giftCertificate.getName()).isEqualTo("book");
//    }
//
//    @Test
//    void getAllGiftCertificateTest() {
//        List<GiftCertificate> giftCertificates = giftCertificateRepository.findAll();
//        Assertions.assertThat(giftCertificates.size()).isGreaterThan(0);
//    }
//
//    @Test
//    void saveGiftCertificateTest() {
//        GiftCertificate giftCertificate = GiftCertificate.builder()
//                .description("awesome")
//                .price(2000.0)
//                .duration(10)
//                .build();
//        giftCertificateRepository.save(giftCertificate);
//        Assertions.assertThat(giftCertificate.getId()).isGreaterThan(1);
//    }
//
//    @Test
//    void deleteGiftCertificateTest() {
//        GiftCertificate giftCertificate = giftCertificateRepository.findById(1);
//        giftCertificateRepository.delete(giftCertificate);
//        GiftCertificate giftCertificate1 = null;
//        Optional<GiftCertificate> optionalGiftCertificate = giftCertificateRepository.findByName("awesome");
//        if (optionalGiftCertificate.isPresent()) {
//            giftCertificate1 = optionalGiftCertificate.get();
//        }
//        Assertions.assertThat(giftCertificate1).isNull();
//    }
//
//    @Test
//    void updateGiftCertificateTest() {
//        GiftCertificate giftCertificate = giftCertificateRepository.findById(1);
//        giftCertificate.setName("tablet");
//
//        GiftCertificate giftCertificateUpdated = giftCertificateRepository.save(giftCertificate);
//        Assertions.assertThat(giftCertificateUpdated.getName()).isEqualTo("laptop");
//    }
//
//    @Test
//    void connectDataBaseTest() throws SQLException, ClassNotFoundException {
//        Connection connection;
//
//        @Before
//                public void before() {
//            connection = SybaseDBConnection.getConnection();
//        }
//        @After
//                public void after() {
//            SybaseDBConnection.closeConnection(connection);
//        }
//        @Test
//                public void closeStatementShouldCloseStatement() {
//            Statement statement = connection.createStatement();
//            SybaseDBConnection.closeStatement(statement);
//            assertTrue(statement.isClosed());
//        }
//        @Test
//                public void closeStatementWithNullShouldNotThrow() {
//            SybaseDBConnection.closeStatement(null);
//        }
//    }
//}
