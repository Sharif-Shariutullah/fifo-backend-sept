package com.example.fifotech.entity;

import com.example.fifotech.dto.PracticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@Table(name = "practice")
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    private String description;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;


public PracticeDto getDto(){

    PracticeDto practiceDto = new PracticeDto();

    practiceDto.setId(id);
    practiceDto.setTitle(title);
    practiceDto.setSubtitle(subtitle);
    practiceDto.setDescription(description);
    practiceDto.setByteImg(img);


    return practiceDto;
};

}
