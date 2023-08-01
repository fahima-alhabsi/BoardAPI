package com.example.BOARD.API.Services;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Reposetries.BoardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepositry boardRepositry;


public List<BoardModel> GetAllBoards(){
    return boardRepositry.findAll();

}

public Optional<BoardModel> GetOneBoard(Long boardId){
return boardRepositry.findById(boardId);


}

public void CreateBoard(BoardModel newBoard ){

    boardRepositry.save(newBoard);

}
public void DeletBoard(Long BoardID){
//    Optional<BoardModel> optionalBoard = boardRepositry.findById(BoardID);
//    if (optionalBoard.isPresent()) {
//        BoardModel Board = optionalBoard.get();
        boardRepositry.delete(boardRepositry.getOne(BoardID));
//    } else {
//        throw new BoardNotFoundException("Board  not found with this ID: " + BoardID);
//    }
}





}
