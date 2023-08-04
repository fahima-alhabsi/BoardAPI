package com.example.BOARD.API.Models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@MappedSuperclass
@Getter
@Setter
@Data
public class baseEntity {
    Date createdDate;
    Date updatedDate;
    Boolean isActive;
}
