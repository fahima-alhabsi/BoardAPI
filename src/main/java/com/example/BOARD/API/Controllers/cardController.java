package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.Services.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController

public class cardController {
    @Autowired
    cardService CardService ;

    @GetMapping("/getCard")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(CardService.GetAllCards());
    }
    @RequestMapping("api/Card/{CardID}")
    public Optional<cardModel> getCardById(@PathVariable Long CardID){
        return CardService.GetOneCard(CardID);
    }

    @PostMapping("/createCard")
    public void createCard(cardModel cardModel){

        com.example.BOARD.API.Models.cardModel Card = new cardModel();
        Card.setTitle(cardModel.getTitle());
        Card.setCreatedDate(new Date());
        Card.setIsActive(true);
        CardService.CreateCard(Card);

    }

    @DeleteMapping("/deleteCard/{CardID}")
    public void DeletCard(@PathVariable Long CardID) {

        CardService.DeletCard(CardID);

    }
    @PutMapping("UpdateCard/{Id}")
    public void UpdatedCard(@PathVariable Long Id, @RequestBody cardModel UpdatedCard) {
        CardService.updateCard(Id,UpdatedCard);

    }


}
