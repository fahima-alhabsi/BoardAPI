package com.example.BOARD.API.ResponseObject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class getCardResponseObject {
    private Long cardId;
    private String title;
    private int  section;
    private String description;
}
