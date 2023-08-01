package com.example.BOARD.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Id;


@Getter
@Setter
@Data
@Entity

public class BoardModel extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

  String name;

}
