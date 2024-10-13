package com.example.fifotech.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String to, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        mailSender.send(message);
    }


    // Multiple email senders
    private final JavaMailSender mailSenderPrimary;
    private final JavaMailSender mailSenderSecondary;


    // Constructor injection for multiple mail senders
    public EmailService(
            @Qualifier("primaryMailSender") JavaMailSender mailSenderPrimary,
            @Qualifier("secondaryMailSender") JavaMailSender mailSenderSecondary) {
        this.mailSenderPrimary = mailSenderPrimary;
        this.mailSenderSecondary = mailSenderSecondary;
    }


    @Qualifier("primaryMailSender")
    private JavaMailSender primaryMailSender;


    @Qualifier("secondaryMailSender")
    private JavaMailSender secondaryMailSender;



    // Method to send email with attachment using different senders
    public void sendEmailWithAttachment(
            String to, String subject, String body, byte[] pdfFile, String pdfFileName, boolean useSecondaryEmail)
            throws MessagingException, IOException {

        // Choose the mail sender based on the flag
        JavaMailSender selectedSender = useSecondaryEmail ? mailSenderSecondary : mailSenderPrimary;

        // Create the MimeMessage for the email
        MimeMessage message = selectedSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Set email details
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        // Attach the PDF file using ByteArrayResource
        helper.addAttachment(pdfFileName, new ByteArrayResource(pdfFile) {
            @Override
            public String getFilename() {
                return pdfFileName;  // Return the actual PDF file name
            }
        });

        // Send the email
        selectedSender.send(message);
    }


}




//
//    public void sendEmailWithAttachment(String to, String subject, String body, File pdfFile, boolean useSecondarySender) throws MessagingException {
//        JavaMailSender mailSender = useSecondarySender ? secondaryMailSender : primaryMailSender;
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject(subject);
//        helper.setText(body, true);
//
//        // Add the attachment
//        helper.addAttachment(pdfFile.getName(), pdfFile);
//
//        mailSender.send(message);
//    }

