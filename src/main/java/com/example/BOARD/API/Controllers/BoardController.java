package com.example.BOARD.API.Controllers;

import com.example.BOARD.API.Models.BoardModel;
import com.example.BOARD.API.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BoardController {
    @Autowired
    BoardService boardService;

}
