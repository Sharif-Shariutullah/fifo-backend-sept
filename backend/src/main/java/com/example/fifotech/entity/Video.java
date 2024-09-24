package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer videoId;

    private String videoName;

    @Column(length = 2000)
    private String videoDetails;

    @Column(length = 2000)
    private String youtubeIframe;


    //video upload korte hobe
//    @Lob
//    @Column(name = "video", length = 5000)
//    private byte[] video;



}
