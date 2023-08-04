package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.RequistObject.getBoardRequistObject;
import com.example.BOARD.API.ResponseObject.getBoardResponseObject;
import com.example.BOARD.API.Services.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
public class boardController {
    @Autowired
    boardService BoardService;


    @PostMapping

    public getBoardResponseObject createBoard(@RequestBody getBoardRequistObject requstedObject) {
        try {
            boardModel Board = new boardModel();
            Board.setTitle(requstedObject.getTitle());
            Board.setCreatedDate(new Date());
            Board.setIsActive(true);
            Map<Integer, String> Columns = new HashMap<>();
            Board.setCreatedDate(new Date());
            Columns.put(1, "To do");
            Columns.put(2, "In progress");
            Columns.put(3, "Done");
            Board.setColumns(Columns);

            return BoardService.createBoard(Board);
        } catch (Exception e) {
            // Handle the exception here (e.g., log the error, return a specific error response, etc.)
            e.printStackTrace();
            throw new RuntimeException("Error creating board. Please try again later.");
        }
    }
    @GetMapping("get")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(BoardService.getAllBoards());
    }

    @RequestMapping("api/board/{BoardId}")
    public Optional<boardModel> getBoardById(@PathVariable Long BoardId){
System.out.println(BoardId);
        return BoardService.getOneBoard(BoardId);
    }




    @DeleteMapping("delete/{BoardID}")
    public void deletBoard(@PathVariable Long BoardID) {

         BoardService.deletBoard(BoardID);

    }

}
