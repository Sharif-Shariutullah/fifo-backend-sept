package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "gallery")
public class Gallery {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer galleryId;

    private String galleryName;
    @Column(length = 2000)
    private String galleryDetails;
//    @Lob
//    @Column(name = "gallery_image", length = 5000)
//    private byte[] galleryImage;




}
