package com.example.BOARD.API.Reposetries;

import com.example.BOARD.API.Models.boardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface boardRepositry extends JpaRepository<boardModel, Long> {


}
