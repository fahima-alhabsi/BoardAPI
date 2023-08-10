package com.example.BOARD.API.Initializer;

import com.example.BOARD.API.Models.boardModel;
import com.example.BOARD.API.Reposetries.boardRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class resourceInitializer implements ApplicationListener<ApplicationReadyEvent> {



        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            if(BoardRepositry.count() == 0){
                boardModel initialBoard = new boardModel();
                initialBoard.setId(1L);
                initialBoard.setTitle("SprintBoot 1111111");
                BoardRepositry.save(initialBoard);

                boardModel initialBoard2 = new boardModel();
                initialBoard2.setId(2L);
                initialBoard2.setTitle("SprintBoot 22222");
                BoardRepositry.save(initialBoard2);
            }
        }
        @Autowired
        private boardRepositry BoardRepositry;
    }

