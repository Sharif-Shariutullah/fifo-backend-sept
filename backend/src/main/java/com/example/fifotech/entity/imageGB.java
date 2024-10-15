package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "image_gb")
public class imageGB {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] img;

    @Column(length = 2000)
    private String caption;

//    @ElementCollection
//    private List<String> imgCap;

    @ManyToOne
    @JoinColumn(name = "global_id")
    private GlobalBPO globalBPO;




}
