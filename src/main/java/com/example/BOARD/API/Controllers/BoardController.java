package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.RequistObject.GetBoardRequistObject;
import com.example.BOARD.API.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController

public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("get")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(boardService.GetAllBoards());
    }
    @PostMapping("/create")
public void CreateBoard(BoardModel boardModel){

BoardModel Board = new BoardModel();
    Board.setName(boardModel.getName());
    Board.setCreatedDate(new Date());
Board.setIsActive(true);
    boardService.CreateBoard(Board);

}



    @DeleteMapping("/delete/{BoardID}")
    public void DeletBoard(@PathVariable Long lsitID) {

         boardService.DeletBoard(lsitID);

    }

}
