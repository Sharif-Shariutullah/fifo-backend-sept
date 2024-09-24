package com.example.fifotech.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PracticeDto {


    private Long id;

    private String title;

    private String subtitle;

    private String description;

    private byte[] byteImg;

    private MultipartFile img;

}
