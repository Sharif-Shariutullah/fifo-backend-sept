package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "global_bpo")
public class GlobalBPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bpoId;

    private String title;
    private String subtitle;

    @Column(length = 3000)
    private String details;

//    //image
//
//    @Lob
//    @Column(name = "bpo_image", length = 5000)
//    private byte[] bpoImage;
//
//    //video
//    @Lob
//    @Column(name = "bpo_video", length = 5000)
//    private byte[] bpoVideo;

}
