package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.ErrorsException.cardNotFoundException;
import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.RequistObject.getCardRequistObject;
import com.example.BOARD.API.ResponseObject.deleteResponse;
import com.example.BOARD.API.ResponseObject.getCardResponseObject;
import com.example.BOARD.API.Services.boardService;
import com.example.BOARD.API.Services.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards/{board_id}/cards")
@CrossOrigin("*")
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

    @GetMapping
    public List<getCardResponseObject> getAllCards(@PathVariable Long board_id) {
        List<getCardResponseObject> allCards = new ArrayList<>();

        try {
            List<cardModel> cards = CardService.getAllCards(board_id);

            for (cardModel card : cards) {
                getCardResponseObject cardResponseObject = new getCardResponseObject();
                cardResponseObject.setCardId(card.getCardId());
                cardResponseObject.setTitle(card.getTitle());
                cardResponseObject.setSection(card.getSection());
                cardResponseObject.setDescription(card.getDescription());
                allCards.add(cardResponseObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allCards;
    }



    @GetMapping("/{card_id}")
    public getCardResponseObject getOneCard(@PathVariable Long board_id, @PathVariable Long card_id) {
        try {
            cardModel card = CardService.getOneCard(board_id,card_id);


            getCardResponseObject cardResponseObject = new getCardResponseObject();
            cardResponseObject.setCardId(card.getCardId());
            cardResponseObject.setTitle(card.getTitle());
            cardResponseObject.setSection(card.getSection());
            cardResponseObject.setDescription(card.getDescription());
            return cardResponseObject;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving card: " + e.getMessage(), e);
        }
    }


    @DeleteMapping("/{card_id}")
    public deleteResponse deleteCard(@PathVariable Long board_id, @PathVariable Long card_id) {
        try {
            CardService.deletCard(board_id,card_id);
            deleteResponse response = new deleteResponse();
            response.setMessage("Card with ID " + card_id + " has been deleted successfully.");
            response.setSuccessful(true);
            return response;
        } catch (cardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while processing the request.", e);
        }
    }




    @PutMapping("/{card_id}")
    public getCardResponseObject updateCard(@PathVariable Long board_id, @PathVariable Long card_id, @RequestBody cardModel updatedCard) {


        try {
            cardModel card = CardService.updateCard(board_id,card_id, updatedCard);
            getCardResponseObject cardResponseObject = new getCardResponseObject();
            cardResponseObject.setCardId(card.getCardId());
            cardResponseObject.setTitle(card.getTitle());
            cardResponseObject.setSection(card.getSection());
            cardResponseObject.setDescription(card.getDescription());
            return cardResponseObject;
        } catch (cardNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while processing the request.", e);
        }
    }





}
