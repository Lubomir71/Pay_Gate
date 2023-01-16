package com.gfa.paygate.service;

import com.gfa.paygate.entity.DTO.CardDataDTO;
import com.gfa.paygate.entity.model.CardData;
import com.gfa.paygate.repository.CardDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Random;

@Service
@AllArgsConstructor
public class PayServiceImpl implements PayService{
    private final CardDataRepository cardDataRepository;

    @Override
    public String payment(CardDataDTO cardDataDTO) {
        String[] validSplit = cardDataDTO.getValid().split("/");
        int month = Integer.parseInt(validSplit[0]);
        int year = Integer.parseInt("20" + validSplit[1]);
        cardDataRepository.save(new CardData(cardDataDTO));
        System.out.println(YearMonth.of(year,month));
        System.out.println(YearMonth.now());
        if (YearMonth.of(year,month).isBefore(YearMonth.now())) throw new IllegalStateException("your card is not valid");
        int rnd = new Random().nextInt(100);
        String returnString = rnd < Integer.parseInt(System.getenv("PROBABILITY")) ?
                "payment was accepted": "payment was rejected";
        return returnString;
    }
}
