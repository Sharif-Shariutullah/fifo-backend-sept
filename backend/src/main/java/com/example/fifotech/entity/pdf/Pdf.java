package com.example.fifotech.entity.pdf;

import com.example.fifotech.entity.TimeTable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
public class Pdf extends TimeTable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String position;
    private int yearsOfExperience;
    private String skills;




    //------------------------file Data-------------
    private String fileName;
    private String fileType;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;


}
