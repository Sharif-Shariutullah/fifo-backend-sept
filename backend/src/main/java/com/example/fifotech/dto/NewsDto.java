package com.example.fifotech.dto;

import jakarta.persistence.ElementCollection;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class NewsDto {


    private Long id;

    private String title;

    private String subtitle;

    @ElementCollection
    private List<String> description;

    private byte[] byteImg;

    private MultipartFile img;


}
