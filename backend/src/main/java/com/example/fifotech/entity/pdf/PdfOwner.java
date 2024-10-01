package com.example.fifotech.entity.pdf;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    private String name;
    private String email;
    private String phone;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pdf_id", referencedColumnName = "id")
//    private Pdf resume;

}
