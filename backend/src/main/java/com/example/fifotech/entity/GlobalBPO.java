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

    private String title;
    private String subtitle;
    private LocalDate postDate;

    @Column(length = 2000)
    private String details;

//    @OneToMany(mappedBy = "globalBPO", cascade = CascadeType.ALL)
//    private List<imageGB> images = new ArrayList<>();
//
//    @ElementCollection
//    @CollectionTable(name = "global_bpo_captions", joinColumns = @JoinColumn(name = "global_bpo_id"))
//    @Column(name = "caption")
//    private List<String> captions = new ArrayList<>();


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "globalBpo")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "global_bpo_id")
    private List<imageGB> images = new ArrayList<>();  // Store multiple images with captions

}
