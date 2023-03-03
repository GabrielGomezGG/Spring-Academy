package com.example.cashcard.controller;


import com.example.cashcard.repository.CashCardRepository;
import com.example.cashcard.models.CashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/cashcards")
public class CashCardController {


    @Autowired
    private CashCardRepository cashCardRepository;

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestedId);
        if (cashCardOptional.isPresent()) {
            return new ResponseEntity<>(cashCardOptional.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<CashCard> addCashCard(@RequestBody CashCard cashCard){
        if(cashCardRepository.existsById(cashCard.getId())){
            return new ResponseEntity<CashCard>(HttpStatus.CONFLICT);
        }
        var response = cashCardRepository.save(cashCard);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCashCard(@PathVariable Long id){
        cashCardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
