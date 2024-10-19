package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
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


    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] thumbnailImage;

    private String title;
    @Column(length = 500)
    private String subtitle;
    private LocalDate postDate;

    @Column(length = 4000)
    private String details;



    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalBpo")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gallery_id")
    private List<ImageGallery> images = new ArrayList<>();


}
