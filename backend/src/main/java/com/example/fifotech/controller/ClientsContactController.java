package com.example.fifotech.controller;

import com.example.fifotech.entity.ClientsContact;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.ContactService;
import com.example.fifotech.services.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ClientsContactController {

    @Autowired
    private ContactService contactService;

    //create
    @PostMapping({"/createContact"})
    public ClientsContact createContact(@RequestBody ClientsContact clientsContact){
        return contactService.createContact(clientsContact);
    }












//     show

    @GetMapping({"/getAlClientsContact"})
    public List<ClientsContact> getAllClientsContact() {
        return contactService.getAllClientsContacts();
    }
    ;

}
