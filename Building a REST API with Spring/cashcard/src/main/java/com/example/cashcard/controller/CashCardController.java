package com.example.cashcard.controller;


import com.example.cashcard.models.CashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcard")
public class CashCardController {

    @GetMapping("/{requestedId}")
    public ResponseEntity<String> findById() {
        return ResponseEntity.ok("{}");
    }
}
