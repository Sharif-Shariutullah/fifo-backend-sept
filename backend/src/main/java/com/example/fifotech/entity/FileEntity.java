package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter // I added
@Setter // I added
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] data;



    // newly added--------------
    private String newsTitle;
    private String newsSubtitle;

    @Temporal(TemporalType.DATE)
    private Date postDate;

    @Lob
    private String newsDescription; // Large description can be stored as a Lob

}
