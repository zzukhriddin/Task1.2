package com.epam.esm.controller;

import com.epam.esm.entity.Gift;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;
import com.epam.esm.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/gift")
public class GiftController {

    @Autowired
    GiftService giftService;

    @GetMapping
    public List<Gift> getGift() throws SQLException, ClassNotFoundException {
        return giftService.getAllGift();
    }
    @GetMapping("{/id}")
    public Gift getById(){
        return giftService.getGiftById();
    }
    @PutMapping("{/id}")
    public ApiResponse editGiftById(@PathVariable Long id){
        return giftService.editGiftById(id);
    }
    @PostMapping
    public HttpEntity<?> saveGift(@RequestBody GiftDto giftDto){
        ApiResponse apiResponse = giftService.saveGift(giftDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("{/id}")
    public HttpEntity<?> deleteGiftById(@PathVariable Long id){
        ApiResponse apiResponse = giftService.deleteGiftById(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);

    }
}
