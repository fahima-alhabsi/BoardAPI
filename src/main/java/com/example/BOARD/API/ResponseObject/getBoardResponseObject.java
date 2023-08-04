package com.example.BOARD.API.ResponseObject;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class getBoardResponseObject {
    Long id;
    String title;
    Map<Integer, String> columns;
}
