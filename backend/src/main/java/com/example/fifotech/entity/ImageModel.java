package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "image_model")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    private String imageName;
    private String imageType;

    @Column(length = 5000000)
    private byte[] picByte;



    //constructor

    public ImageModel() {

    }


    public ImageModel(String imageName, String imageType, byte[] picByte) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.picByte = picByte;
    }
}
