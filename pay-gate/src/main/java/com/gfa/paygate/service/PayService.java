package com.gfa.paygate.service;

import com.gfa.paygate.entity.DTO.CardDataDTO;

public interface PayService {
    String payment (CardDataDTO cardData);
}
