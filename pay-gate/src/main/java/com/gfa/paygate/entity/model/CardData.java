package com.gfa.paygate.entity.model;

import com.gfa.paygate.entity.DTO.CardDataDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class CardData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String number;
    private String valid;
    private String cvv;

    public CardData(CardDataDTO cardDataDTO){
        this.name = cardDataDTO.getName();
        this.number = cardDataDTO.getNumber();
        this.valid = cardDataDTO.getValid();
        this.cvv = cardDataDTO.getCvv();
    }
}
