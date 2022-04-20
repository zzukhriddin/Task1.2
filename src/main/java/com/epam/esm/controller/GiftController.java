package com.epam.esm.controller;

import com.epam.esm.entity.Gift;
import com.epam.esm.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/gift")
public class GiftController {

    @Autowired
    GiftService giftService;

    @GetMapping
    public List<Gift> getGift(){
        return giftService.getAllGift();

    }
}
