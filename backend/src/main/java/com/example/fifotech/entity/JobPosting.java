package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "job_postings")
public class JobPosting{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobTitle;
    @Column(length = 2000)
    private String jobDescription;
    private Double salary;
    private Integer experienceRequired;
    private String educationQualification;
    private LocalDate applicationDeadline;
    private String contactInformation;


    @ElementCollection
    private List<String> responsibilities;

    @ElementCollection
    private List<String> requirements;

    @ElementCollection
    private List<String> whatWeOffer;


}
