package com.gfa.paygate.repository;

import com.gfa.paygate.entity.model.CardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDataRepository extends JpaRepository<CardData,Long> {

}
