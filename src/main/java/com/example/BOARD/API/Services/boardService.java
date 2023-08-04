package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Reposetries.boardRepositry;
import com.example.BOARD.API.RequistObject.getCardRequistObject;
import com.example.BOARD.API.ResponseObject.deleteResponse;
import com.example.BOARD.API.ResponseObject.getBoardResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class boardService {
    @Autowired
    boardRepositry BoardRepositry;



    public getBoardResponseObject createBoard(boardModel newBoard) {
        try {
            boardModel savedBoard = BoardRepositry.save(newBoard);
            getBoardResponseObject getBoardResponseObject = new getBoardResponseObject();
            getBoardResponseObject.setTitle(savedBoard.getTitle());
            getBoardResponseObject.setColumns(savedBoard.getColumns());
            getBoardResponseObject.setId(savedBoard.getId());

            return getBoardResponseObject;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating board. Please try again later.");
        }
    }
public List<boardModel> getAllBoards(){
    return BoardRepositry.findAll();

}
    public boardModel getOneBoard(Long boardId) {
        try {
            return BoardRepositry.getReferenceById(boardId);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving board from repository: " + e.getMessage(), e);
        }
    }

    public deleteResponse deleteBoard(Long BoardID) {
        try {
            Optional<boardModel> boeardObj = Optional.of(BoardRepositry.getOne(BoardID));
            try {

                BoardRepositry.deleteById(BoardID);
                deleteResponse deleteResponse = new deleteResponse();
                deleteResponse.setMessage("Board with ID " + BoardID + " has been deleted successfully.");
                deleteResponse.setSuccessful(true);
                return deleteResponse;

            } catch (Exception e) {
                deleteResponse deleteResponse = new deleteResponse();
                deleteResponse.setMessage("An error occurred while deleting the board with ID " + BoardID);
                deleteResponse.setSuccessful(false);
                return deleteResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public deleteResponse updateBoard(Long BoardID) {
        try {
            Optional<boardModel> boeardObj = Optional.of(BoardRepositry.getOne(BoardID));
            try {

                BoardRepositry.deleteById(BoardID);
                deleteResponse deleteResponse = new deleteResponse();
                deleteResponse.setMessage("Board with ID " + BoardID + " has been deleted successfully.");
                deleteResponse.setSuccessful(true);
                return deleteResponse;

            } catch (Exception e) {
                deleteResponse deleteResponse = new deleteResponse();
                deleteResponse.setMessage("An error occurred while deleting the board with ID " + BoardID);
                deleteResponse.setSuccessful(false);
                return deleteResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }




    public void updateBoard( boardModel updatedBoard) {
        BoardRepositry.save(updatedBoard);

    }

}