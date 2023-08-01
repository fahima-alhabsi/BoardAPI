package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.RequistObject.GetBoardRequistObject;
import com.example.BOARD.API.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController

public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("get")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(boardService.GetAllBoards());
    }

public void CreateBoard(GetBoardRequistObject getBoardRequistObject){
BoardModel Board = new BoardModel();
    Board.setName("NAME");
    Board.setCreatedDate(new Date());
Board.setIsActive(true);
    boardService.CreateBoard(Board);

}





}
