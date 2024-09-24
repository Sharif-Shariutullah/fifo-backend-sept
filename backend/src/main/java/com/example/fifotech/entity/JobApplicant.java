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
public class JobApplicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private LocalDate applicationDate;

//    @Lob
//    @Column(nullable = true)
//    private byte[] resumePdf;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "applicant_images", joinColumns = {@JoinColumn(name = "applicant_id")},
//            inverseJoinColumns = {@JoinColumn(name = "image_id")})
//    private Set<ImageModel> applicantImages;



}


//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private JobOpportunity jobOpportunity;

//    @Lob
//    @Column(nullable = true)
//    private byte[] image;