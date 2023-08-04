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


public List<boardModel> getAllBoards(){
    return BoardRepositry.findAll();

}

public Optional<boardModel> getOneBoard(Long boardId){
return BoardRepositry.findById(boardId);


}

public void createBoard(boardModel newBoard ){

    BoardRepositry.save(newBoard);

}
public void deletBoard(Long BoardID){

        BoardRepositry.delete(BoardRepositry.getOne(BoardID));

}





}
