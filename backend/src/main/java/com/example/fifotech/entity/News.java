package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long newsId;

    private String title;

    @Column(length = 5000)
    private String content;

    private String author;

    private LocalDateTime publishedAt;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "news_images",
            joinColumns = {
                    @JoinColumn(name = "news_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "image_id")
            })
    private Set<ImageModel> newsImages;


}
