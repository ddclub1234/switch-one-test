package com.switchone.homework.service;

import com.switchone.homework.entity.Merchant;
import com.switchone.homework.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public Merchant getMerchant(Long merchantId){
        return merchantRepository.findById(merchantId)
                .orElseThrow(() -> new RuntimeException("상점 ID " +merchantId+ "은 존재하지 않는 아이디입니다."));
    }
}
