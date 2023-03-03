package com.example.cashcard.repository;


import com.example.cashcard.models.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashCardRepository extends JpaRepository<CashCard,Long> {
}
