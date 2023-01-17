package com.gfa.paygate.service;

import com.gfa.paygate.entity.DTO.CardDataDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Random;

@Service
@AllArgsConstructor
public class PayServiceImpl implements PayService{

    @Override
    public String payment(CardDataDTO cardDataDTO) {
        String[] validSplit = cardDataDTO.getValid().split("/");
        int month = Integer.parseInt(validSplit[0]);
        int year = Integer.parseInt("20" + validSplit[1]);
        if (YearMonth.of(year,month).isBefore(YearMonth.now())) throw new IllegalStateException("your card is not valid");
        int rnd = new Random().nextInt(100);
        String returnString = rnd < Integer.parseInt(System.getenv("PROBABILITY")) ?
                "payment was accepted": "payment was rejected";
        return returnString;
    }
}
