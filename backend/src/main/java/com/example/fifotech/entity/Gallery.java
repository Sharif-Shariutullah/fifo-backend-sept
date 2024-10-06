package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

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
    private Long id;

    private String title;
    private String subtitle;
    private LocalDate postDate;

    @Column(length = 2000)
    private String details;


    @ElementCollection
    private List<String> caption;


    @Lob
    @Column(columnDefinition = "longblob")
    private  List<byte[]> img;

//    private MultipartFile MultiImg;


}
