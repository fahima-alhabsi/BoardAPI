package com.example.BOARD.API.Services;

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

        return CardRepositry.save(newCard);
    }


    public List<cardModel> getAllCards(Long id) {
        return CardRepositry.findcards(id);

    }


    public cardModel getOneCard(Long boardId, Long cardId) {
        return CardRepositry.findOneCard(boardId, cardId);
    }

    public void deletCard(Long boardId, Long CardID) {
        boardModel board = BoardRepositry.getReferenceById(boardId);
        if (board != null) {
            CardRepositry.delete(CardRepositry.getOne(CardID));
        }
    }


    public cardModel updateCard(Long boardId, Long cardId, cardModel updatedCard) {
        boardModel board = BoardRepositry.getReferenceById(boardId);
        if (board != null) {
            cardModel card = CardRepositry.getReferenceById(cardId);
            card.setTitle(updatedCard.getTitle());
            card.setSection(updatedCard.getSection());
            card.setDescription(updatedCard.getDescription());
            return CardRepositry.save(card);
        }
        return updatedCard;
    }

}






//    public cardModel updateCard(Long id, cardModel updatedCards) {
//
//        CardRepositry.save(updatedCards);
//        return CardRepositry.findById(id).get();
//
//    }


