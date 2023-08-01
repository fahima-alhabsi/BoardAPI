package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Models.CardModel;
import com.example.BOARD.API.Reposetries.CardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepositry cardRepositry;



    public void GetOneCard (){

    }
public void CreateCard(){

}


        public List<CardModel> GetAllCards(){
            return cardRepositry.findAll();

        }




    public void DeleteOneCard(){

    }

    public void UpdateCard (){

    }

}
