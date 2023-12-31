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

public class cardModel extends baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToOne
    @JoinColumn(name = "id")
    private boardModel BoardModel;

    private String title;
    private int  section;
    private String description;

}
