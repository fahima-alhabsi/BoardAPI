package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Models.CardModel;
import com.example.BOARD.API.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController

public class CardController {
    @Autowired
    CardService cardService ;

    @GetMapping("/getCard")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(cardService.GetAllCards());
    }
    @RequestMapping("api/Card/{CardID}")
    public Optional<CardModel> getCardById(@PathVariable Long CardID){
        return cardService.GetOneCard(CardID);
    }

    @PostMapping("/createCard")
    public void createCard(CardModel cardModel){

        CardModel Card = new CardModel();
        Card.setTitle(cardModel.getTitle());
        Card.setCreatedDate(new Date());
        Card.setIsActive(true);
        cardService.CreateCard(Card);

    }

    @DeleteMapping("/deleteCard/{CardID}")
    public void DeletCard(@PathVariable Long CardID) {

        cardService.DeletCard(CardID);

    }
    @PutMapping("UpdateCard/{Id}")
    public void UpdatedCard(@PathVariable Long Id, @RequestBody CardModel UpdatedCard) {
        cardService.updateCard(Id,UpdatedCard);

    }


}
