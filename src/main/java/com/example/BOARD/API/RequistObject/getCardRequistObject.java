package com.example.BOARD.API.RequistObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class getCardRequistObject {
    private Long cardId;

    private String title;
    private String  section;
    private String description;
}
