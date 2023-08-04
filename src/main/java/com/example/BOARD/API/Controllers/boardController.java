package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.RequistObject.getBoardRequistObject;
import com.example.BOARD.API.ResponseObject.getBoardResponseObject;
import com.example.BOARD.API.Services.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @GetMapping
    public List<getBoardResponseObject> findAll() {
        List<getBoardResponseObject> allBoards = new ArrayList<>();

        try {
            List<boardModel> boards = BoardService.getAllBoards();

            for (boardModel board : boards) {
                getBoardResponseObject getBoardResponseObject = new getBoardResponseObject();
                getBoardResponseObject.setTitle(board.getTitle());
                getBoardResponseObject.setColumns(board.getColumns());
                getBoardResponseObject.setId(board.getId());
                allBoards.add(getBoardResponseObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allBoards;
    }

    @RequestMapping("{BoardId}")
    public getBoardResponseObject getBoardById(@PathVariable Long BoardId) {
        try {
            boardModel boardModel = BoardService.getOneBoard(BoardId);
            getBoardResponseObject getBoardResponseObject = new getBoardResponseObject();
            getBoardResponseObject.setTitle(boardModel.getTitle());
            getBoardResponseObject.setColumns(boardModel.getColumns());
            getBoardResponseObject.setId(boardModel.getId());
            return getBoardResponseObject;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving board: " + e.getMessage(), e);
        }
    }



    @DeleteMapping("delete/{BoardID}")
    public void deletBoard(@PathVariable Long BoardID) {

         BoardService.deletBoard(BoardID);

    }

}
