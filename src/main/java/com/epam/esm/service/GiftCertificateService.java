package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;
import com.epam.esm.repository.GiftCertificateRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
//@ComponentScan
public class GiftCertificateService {

    GiftCertificateRepository giftRepository=new GiftCertificateRepository();
    public GiftDto getGiftCertificateById(Long id) throws SQLException, ClassNotFoundException {
        return giftRepository.getById(id);
    }

    public GiftCertificate getGiftCertificateByName(String name) throws SQLException, ClassNotFoundException {
        return giftRepository.getByName(name);
    }
    public List<GiftCertificate> getAllGiftCertificate() throws SQLException, ClassNotFoundException {
        return giftRepository.getAll();
    }

    public ApiResponse saveGiftCertificate(GiftDto giftDto) {
        try {
            giftRepository.save(giftDto);
            return new ApiResponse("successfully saved", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }

    public ApiResponse editGiftCertificateById(Long id, GiftDto giftDto) {
        try {
            giftRepository.edit(id,giftDto);
            return new ApiResponse("successfully edited", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }

    public ApiResponse deleteGiftCertificateById(Long id) {
        try {
            giftRepository.delete(id);
            return new ApiResponse("successfully deleted", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }
}
