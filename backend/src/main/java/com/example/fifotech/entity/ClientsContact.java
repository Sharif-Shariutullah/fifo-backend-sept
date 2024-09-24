package com.example.fifotech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "client_contact_info")
public class ClientsContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;
    private String companyName;
    private String companyAddress;
    private String clientName;
    private String email;
    private String companyPhone;
    private String companyMobileNumber;


    @Column(length = 5000)
    private String message;

}
