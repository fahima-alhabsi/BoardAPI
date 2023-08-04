package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Services.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController

public class boardController {
    @Autowired
    boardService BoardService;

    @GetMapping("get")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(BoardService.getAllBoards());
    }

    @RequestMapping("api/board/{BoardId}")
    public Optional<boardModel> getBoardById(@PathVariable Long BoardId){
System.out.println(BoardId);
        return BoardService.getOneBoard(BoardId);
    }

    @PostMapping("/create")
public void createBoard(boardModel boardModel){

        boardModel Board = new boardModel();
    Board.setName(boardModel.getName());
    Board.setCreatedDate(new Date());
Board.setIsActive(true);
    BoardService.createBoard(Board);

}


    @DeleteMapping("delete/{BoardID}")
    public void deletBoard(@PathVariable Long BoardID) {

         BoardService.deletBoard(BoardID);

    }

}
