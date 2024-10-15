package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "applicants")
public class JobApplicant extends TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    private String name;
    private String address;
    private String email;
    private String phone;
    private String position;
    private Long yearsOfExperience;

    @Column(length = 5000)
    private String skills;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] pdfFile;





}





//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "applicant_images", joinColumns = {@JoinColumn(name = "applicant_id")},
//            inverseJoinColumns = {@JoinColumn(name = "image_id")})
//    private Set<ImageModel> applicantImages;




//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)

//    @Lob
//    @Column(nullable = true)
//    private byte[] image;