package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController

public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("get")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(boardService.GetAllBoards());
    }

    @RequestMapping("api/board/{BoardId}")
    public Optional<BoardModel> getBoardById(@PathVariable Long BoardId){
System.out.println(BoardId);
        return boardService.GetOneBoard(BoardId);
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
    public void DeletBoard(@PathVariable Long BoardID) {

         boardService.DeletBoard(BoardID);

    }

}
