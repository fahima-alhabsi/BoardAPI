package com.example.BOARD.API.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
@Getter
@Setter
@Data
@Entity

public class CardModel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cardId;

    @ManyToOne
    @JoinColumn(name = "id")
    BoardModel boardModel;


    String title;
    String  section;
    String description;

}
