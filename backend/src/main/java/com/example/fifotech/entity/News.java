package com.example.fifotech.entity;

import com.example.fifotech.dto.NewsDto;
import com.example.fifotech.dto.PracticeDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;



    @ElementCollection
    private List<String> description;


    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;


    public NewsDto getDto() {

        NewsDto newsDto = new NewsDto();

        newsDto.setId(id);
        newsDto.setTitle(title);
        newsDto.setSubtitle(subtitle);
        newsDto.setDescription(description);
        newsDto.setByteImg(img);


        return newsDto;
    }

    ;

}
