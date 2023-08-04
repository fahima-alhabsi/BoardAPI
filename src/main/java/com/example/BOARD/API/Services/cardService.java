package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.Reposetries.cardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {
    @Autowired
    cardRepositry CardRepositry;



    public cardModel getOneCard(Long CardID){
        return CardRepositry.getReferenceById(CardID);

    }


    public cardModel createCard(cardModel newCard ){

        return CardRepositry.save(newCard);
    }


        public List<cardModel> getAllCards(){
            return CardRepositry.findAll();

        }


    public void deletCard(Long CardID){
        CardRepositry.delete(CardRepositry.getOne(CardID));
    }

    public cardModel updateCard(Long id, cardModel updatedCards) {



        CardRepositry.save(updatedCards);
        return CardRepositry.findById(id).get();

    }

}
