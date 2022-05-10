package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;
import com.epam.esm.repository.GiftRepository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class GiftService {

    GiftRepository giftRepository=new GiftRepository();
    public List<GiftCertificate> getAllGift() throws SQLException, ClassNotFoundException {
        return giftRepository.getAll();
    }

    public ApiResponse editGiftById(Long id, GiftDto giftDto) {
        try {
            giftRepository.edit(id,giftDto);
            return new ApiResponse("successfully edited", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }
    public ApiResponse saveGift(GiftDto giftDto) {
        try {
            giftRepository.save(giftDto);
            return new ApiResponse("successfully saved", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }

    public ApiResponse deleteGiftById(Long id) {
        try {
            giftRepository.delete(id);
            return new ApiResponse("successfully deleted", true);
        }catch (Exception e){
            return new ApiResponse("failed", false);
        }
    }

    public GiftCertificate getGiftById() {
        return null;
    }

    public String checkService() {
        return "Service Startedd";
    }
}
