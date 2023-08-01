package com.example.BOARD.API.Reposetries;

import com.example.BOARD.API.Models.BoardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepositry extends JpaRepository<BoardModel, Long> {
}
