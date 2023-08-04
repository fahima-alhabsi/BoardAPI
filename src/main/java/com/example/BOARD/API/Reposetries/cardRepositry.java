package com.example.BOARD.API.Reposetries;

import com.example.BOARD.API.Models.cardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cardRepositry extends JpaRepository<cardModel, Long> {
}
