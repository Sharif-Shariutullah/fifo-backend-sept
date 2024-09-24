package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "team_member")
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teamMemberId;

    private String name;
    private String designation;
    private String mail;
    private String linkedInId;

    @Column(length = 3000)
    private String details;

//    @Lob
//    @Column(name = "team_image", length = 5000)
//    private byte[] teamImage;


}
