package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Models.CardModel;
import com.example.BOARD.API.Reposetries.CardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepositry cardRepositry;



    public Optional<CardModel> GetOneCard(Long CardID){
        return cardRepositry.findById(CardID);

    }


    public void CreateCard(CardModel newCard ){

        cardRepositry.save(newCard);

    }


        public List<CardModel> GetAllCards(){
            return cardRepositry.findAll();

        }


    public void DeletCard(Long CardID){
        cardRepositry.delete(cardRepositry.getOne(CardID));
    }

    public CardModel updateCard(Long id, CardModel updatedCards) {



        cardRepositry.save(updatedCards);
        return cardRepositry.findById(id).get();

    }

}
