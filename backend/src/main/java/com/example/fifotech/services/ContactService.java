package com.example.fifotech.services;

import com.example.fifotech.entity.ClientsContact;
import com.example.fifotech.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;


    @Autowired
    private EmailService emailService;


    //    create
    public ClientsContact createContact(ClientsContact contact) {


        ClientsContact savedContact = contactRepository.save(contact);

        // Prepare email contentS
        String subject = "New Contact Request from " + contact.getClientName();


        String body = "<h1>New Contact Request</h1>" +
                "<p><strong>Company Name:</strong> " + contact.getCompanyName() + "</p>" +
                "<p><strong>Address:</strong> " + contact.getCompanyAddress() + "</p>" +
                "<p><strong>Name:</strong> " + contact.getClientName() + "</p>" +
                "<p><strong>Email:</strong> " + contact.getEmail() + "</p>" +
                "<p><strong>Phone:</strong> " + contact.getCompanyPhone() + "</p>" +
                "<p><strong>Mobile:</strong> " + contact.getCompanyMobileNumber() + "</p>" +
                "<p><strong>Message:</strong> " + contact.getMessage() + "</p>";

        try {
            // Send the email
            emailService.sendContactEmail("wetechhub.info@gmail.com", subject, body);
        } catch (Exception e) {
            // Handle email sending error
            e.printStackTrace();
        }


//        return contactRepository.save(contact);

        return savedContact;
    }




















    // show from db to website
    public List<ClientsContact> getAllClientsContacts() {
        return (List<ClientsContact>) contactRepository.findAll();

    }

}
