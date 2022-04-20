package com.epam.esm.service;

import com.epam.esm.entity.Gift;
import com.epam.esm.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    @Autowired
    GiftRepository giftRepository;
    public List<Gift> getAllGift() {
        return giftRepository.getAll();
    }
}
