package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Reposetries.boardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class boardService {
    @Autowired
    boardRepositry BoardRepositry;


public List<boardModel> GetAllBoards(){
    return BoardRepositry.findAll();

}

public Optional<boardModel> GetOneBoard(Long boardId){
return BoardRepositry.findById(boardId);


}

public void CreateBoard(boardModel newBoard ){

    BoardRepositry.save(newBoard);

}
public void DeletBoard(Long BoardID){
//    Optional<BoardModel> optionalBoard = boardRepositry.findById(BoardID);
//    if (optionalBoard.isPresent()) {
//        BoardModel Board = optionalBoard.get();
        BoardRepositry.delete(BoardRepositry.getOne(BoardID));
//    } else {
//        throw new BoardNotFoundException("Board  not found with this ID: " + BoardID);
//    }
}





}
