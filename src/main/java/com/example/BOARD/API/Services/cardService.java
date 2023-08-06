package com.example.BOARD.API.Services;

import com.example.BOARD.API.ErrorsException.boardNotFoundException;
import com.example.BOARD.API.ErrorsException.cardNotFoundException;
import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.Reposetries.boardRepositry;
import com.example.BOARD.API.Reposetries.cardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {
    @Autowired
    cardRepositry CardRepositry;
    @Autowired
    boardRepositry BoardRepositry;

    public cardModel createCard(cardModel newCard) {
        try {
            return CardRepositry.save(newCard);
        } catch (Exception e) {
            throw new cardNotFoundException("Error while creating the card: " + e.getMessage());
        }
    }



    public List<cardModel> getAllCards(Long id) {
        List<cardModel> cards = CardRepositry.findcards(id);
        if (cards.isEmpty()) {
            throw new cardNotFoundException("No cards found for the given id: " + id);
        }
        return cards;
    }



    public cardModel getOneCard(Long boardId, Long cardId) {
        cardModel card = CardRepositry.findOneCard(boardId, cardId);
        if (card == null) {
            throw new cardNotFoundException("Card with id " + cardId + " not found in board with id " + boardId);
        }
        return card;
    }




    public void deletCard(Long boardId, Long cardId) {
        boardModel board = BoardRepositry.getReferenceById(boardId);
        if (board != null) {
            cardModel card = CardRepositry.getOne(cardId);
            if (card == null) {
                throw new cardNotFoundException("Card with id " + cardId + " not found");
            }
            CardRepositry.delete(card);
        } else {
            throw new boardNotFoundException("Board with id " + boardId + " not found");
        }
    }





    public cardModel updateCard(Long boardId, Long cardId, cardModel updatedCard) {
        boardModel board = BoardRepositry.getReferenceById(boardId);
        if (board != null) {
            cardModel card = CardRepositry.getOne(cardId);
            if (card == null) {
                throw new cardNotFoundException("Card with id " + cardId + " not found");
            }

            // Update the card properties with the updated values
            card.setTitle(updatedCard.getTitle());
            card.setSection(updatedCard.getSection());
            card.setDescription(updatedCard.getDescription());

            return CardRepositry.save(card);
        } else {
            throw new boardNotFoundException("Board with id " + boardId + " not found");
        }
    }

}









