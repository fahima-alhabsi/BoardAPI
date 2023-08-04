package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Reposetries.boardRepositry;
import com.example.BOARD.API.ResponseObject.getBoardResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

public Optional<boardModel> getOneBoard(Long boardId){
return BoardRepositry.findById(boardId);


}


public void deletBoard(Long BoardID){

        BoardRepositry.delete(BoardRepositry.getOne(BoardID));

}





}
