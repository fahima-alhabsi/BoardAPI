package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Models.CardModel;
import com.example.BOARD.API.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController

public class CardController {
    @Autowired
    CardService cardService ;

    @GetMapping("getcard")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(cardService.GetAllCards());
    }



    @PostMapping("/createcard")
    public void createCard(CardModel cardModel){

        CardModel Card = new CardModel();
        Card.setTitle(cardModel.getTitle());
        Card.setCreatedDate(new Date());
        Card.setIsActive(true);
        cardService.CreateCard(Card);

    }





}
