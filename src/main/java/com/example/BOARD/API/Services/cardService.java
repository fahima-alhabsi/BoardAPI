package com.example.BOARD.API.Services;

import com.example.BOARD.API.ErrorsException.cardNotFoundException;
import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.Reposetries.cardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {
    @Autowired
    cardRepositry CardRepositry;


    public cardModel createCard(cardModel newCard ){

        return CardRepositry.save(newCard);
    }



        public List<cardModel> getAllCards(){
            return CardRepositry.findAll();

        }


    public cardModel getOneCard(Long cardId) {
        return CardRepositry.findById(cardId)
                .orElseThrow(() -> new cardNotFoundException("Card with ID " + cardId + " not found."));
    }




    public void deletCard(Long CardID){

        CardRepositry.delete(CardRepositry.getOne(CardID));
    }



    public cardModel updateCard(Long cardId, cardModel updatedCard) {
        cardModel card = getOneCard(cardId);
        card.setTitle(updatedCard.getTitle());
        card.setSection(updatedCard.getSection());
        card.setDescription(updatedCard.getDescription());
        return CardRepositry.save(card);
    }








//    public cardModel updateCard(Long id, cardModel updatedCards) {
//
//        CardRepositry.save(updatedCards);
//        return CardRepositry.findById(id).get();
//
//    }

}
