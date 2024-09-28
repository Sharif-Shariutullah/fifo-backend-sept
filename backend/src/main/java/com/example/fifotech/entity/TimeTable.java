package com.example.fifotech.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//@Entity
@MappedSuperclass
@Data
public class TimeTable {


    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDateTime lastUpdated;

}
