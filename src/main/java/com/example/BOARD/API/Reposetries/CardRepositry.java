package com.example.BOARD.API.Reposetries;

import com.example.BOARD.API.Models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepositry extends JpaRepository<CardModel, Long> {
}
