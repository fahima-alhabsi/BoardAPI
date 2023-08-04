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

        return ResponseEntity.ok(CardService.getAllCards());
    }
//    @RequestMapping("api/Card/{CardID}")
//    public Optional<cardModel> getCardById(@PathVariable Long CardID){
//        return CardService.getOneCard(CardID);
//    }

    @PostMapping("/createCard")
    public void createCard(cardModel cardModel){

        cardModel Card = new cardModel();
        Card.setTitle(cardModel.getTitle());
        Card.setCreatedDate(new Date());
        Card.setIsActive(true);
        CardService.createCard(Card);

    }

    @DeleteMapping("/deleteCard/{CardID}")
    public void deletCard(@PathVariable Long CardID) {

        CardService.deletCard(CardID);

    }
    @PutMapping("UpdateCard/{Id}")
    public void updatedCard(@PathVariable Long Id, @RequestBody cardModel UpdatedCard) {
        CardService.updateCard(Id,UpdatedCard);

    }


}
