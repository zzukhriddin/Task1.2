package com.epam.esm.controller;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.payload.ApiResponse;
import com.epam.esm.payload.GiftDto;
import com.epam.esm.service.GiftCertificateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/gift")
public class GiftCertificateController {


    private final GiftCertificateService giftCertificateService;

    /**
     *  this controller return gift object by id
     * @param  id
     * @return Gift object
     */
    @SneakyThrows
    @GetMapping("/{id}")
    public GiftCertificate getById(@PathVariable Long id){
        return giftCertificateService.getGiftCertificateById(id);
    }

    /**
     * @return List
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @GetMapping
    public List<GiftCertificate> getGift() throws SQLException, ClassNotFoundException {
        System.out.println("test api worked");
        return giftCertificateService.getAllGiftCertificate();
    }

    /**
     * this controller return gift object by id
     * @param  id
     * @param giftDto
     * @return giftDto
     */
    @PutMapping("/{id}")
    public ApiResponse editGiftById(@PathVariable Long id, @RequestBody GiftDto giftDto){
        return giftCertificateService.editGiftCertificateById(id,giftDto);
    }

    /**
     *
     * @param giftDto
     * @return HttpEntity
     */
    @PostMapping
    public HttpEntity<?> saveGift(@RequestBody GiftDto giftDto){
        ApiResponse apiResponse = giftCertificateService.saveGiftCertificate(giftDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    /**
     *a
     * @param id
     * @return HttpEntity
     */
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGiftById(@PathVariable Long id){
        ApiResponse apiResponse = giftCertificateService.deleteGiftCertificateById(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);

    }
}
