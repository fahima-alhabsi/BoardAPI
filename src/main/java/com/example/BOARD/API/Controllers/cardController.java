package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.RequistObject.getCardRequistObject;
import com.example.BOARD.API.ResponseObject.getCardResponseObject;
import com.example.BOARD.API.Services.boardService;
import com.example.BOARD.API.Services.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards/{board_id}/cards")
public class cardController {
    @Autowired
    cardService CardService ;

    @Autowired
    boardService BoardService;
    @PostMapping
    public getCardResponseObject createCard(@PathVariable Long board_id, @RequestBody getCardRequistObject cardModel) {
        try {
            cardModel Card = new cardModel();
            Card.setTitle(cardModel.getTitle());
            Card.setDescription(cardModel.getDescription());
            Card.setSection(cardModel.getSection());
            Card.setCreatedDate(new Date());
            Card.setIsActive(true);
            Card.setBoardModel(BoardService.getOneBoard(board_id));
            cardModel savedCard = CardService.createCard(Card);
            return new getCardResponseObject(savedCard.getCardId(), savedCard.getTitle(), savedCard.getSection(), savedCard.getDescription());
        } catch (Exception e) {

            throw e;
        }
    }


    @GetMapping("/getCard")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(CardService.getAllCards());
    }
//    @RequestMapping("api/Card/{CardID}")
//    public Optional<cardModel> getCardById(@PathVariable Long CardID){
//        return CardService.getOneCard(CardID);
//    }


    @DeleteMapping("/deleteCard/{CardID}")
    public void deletCard(@PathVariable Long CardID) {

        CardService.deletCard(CardID);

    }
    @PutMapping("UpdateCard/{Id}")
    public void updatedCard(@PathVariable Long Id, @RequestBody cardModel UpdatedCard) {
        CardService.updateCard(Id,UpdatedCard);

    }


}
