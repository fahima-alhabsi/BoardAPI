package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.cardModel;
import com.example.BOARD.API.Reposetries.cardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cardService {
    @Autowired
    cardRepositry CardRepositry;



    public Optional<cardModel> GetOneCard(Long CardID){
        return CardRepositry.findById(CardID);

    }


    public void CreateCard(cardModel newCard ){

        CardRepositry.save(newCard);

    }


        public List<cardModel> GetAllCards(){
            return CardRepositry.findAll();

        }


    public void DeletCard(Long CardID){
        CardRepositry.delete(CardRepositry.getOne(CardID));
    }

    public cardModel updateCard(Long id, cardModel updatedCards) {



        CardRepositry.save(updatedCards);
        return CardRepositry.findById(id).get();

    }

}
