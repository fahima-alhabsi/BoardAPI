package com.example.BOARD.API.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@Data
@Entity

public class boardModel extends baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ElementCollection
    @CollectionTable(name = "sections", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "sectionId")
    @Column(name = "name")
    private Map<Integer, String> columns;
}
