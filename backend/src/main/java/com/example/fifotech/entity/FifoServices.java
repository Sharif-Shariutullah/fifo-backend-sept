package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "fifo_services")
public class FifoServices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serviceId;

    private String serviceName;

    @Column(length = 2000)
    private String serviceDetails;

//    @Lob
//    @Column(name = "service_image", length = 5000)
//    private byte[] serviceImage;




}
