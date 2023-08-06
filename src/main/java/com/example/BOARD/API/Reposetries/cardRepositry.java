package com.example.BOARD.API.Reposetries;

import com.example.BOARD.API.Models.cardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cardRepositry extends JpaRepository<cardModel, Long> {
    @Query("SELECT card FROM cardModel card WHERE card.BoardModel.id = :boardid")
    List<cardModel> findcards(@Param("boardid") Long boardid);

    @Query("SELECT card FROM cardModel card WHERE card.BoardModel.id = :boardid AND card.cardId = :cardId")
    cardModel findOneCard(@Param("boardid") Long boardid,@Param("cardId") Long cardID);



}
