package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "global_bpo")
public class GlobalBPO {

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
    @JoinColumn(name = "global_bpo_id")
    private List<imageGB> images = new ArrayList<>();


}
