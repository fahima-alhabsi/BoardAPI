package com.example.BOARD.API.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;
@Getter
@Setter
@Data
@Entity

public class CardModel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String title;
    String  section;
    String description;
}
