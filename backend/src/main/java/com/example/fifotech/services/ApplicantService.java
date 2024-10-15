package com.example.fifotech.services;


import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.repository.ApplicantRepository;
import com.example.fifotech.repository.FileRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private EmailService emailService;



    public JobApplicant applyForNewJob(String name, String address, String email, String phone,
                                       String position, Long yearsOfExperience, String skills,
                                       MultipartFile pdfFile) throws IOException, MessagingException {

        JobApplicant jobApplicant = new JobApplicant();
        jobApplicant.setName(name);
        jobApplicant.setAddress(address);
        jobApplicant.setEmail(email);
        jobApplicant.setPhone(phone);
        jobApplicant.setPosition(position);
        jobApplicant.setYearsOfExperience(yearsOfExperience);
        jobApplicant.setSkills(skills);
        jobApplicant.setPdfFile(pdfFile.getBytes());  // Convert file to bytes

        JobApplicant savedApplicant = applicantRepository.save(jobApplicant);


// Prepare email details
//        String subject = "New Job Application from " + name;
        String subject =  "Apply for " + position;

//        String body = "<p><strong>Name:</strong> " + name + "</p>"
//                + "<p><strong>Address:</strong> " + address + "</p>"
//                + "<p><strong>Email:</strong> " + email + "</p>"
//                + "<p><strong>Phone:</strong> " + phone + "</p>"
//                + "<p><strong>Position Applied:</strong> " + position + "</p>"
//                + "<p><strong>Years of Experience:</strong> " + yearsOfExperience + "</p>"
//                + "<p><strong>Skills:</strong> " + skills + "</p>";



        String body = "<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>"
                + "<tr>"
                + "<td><strong><i class='fa fa-user'></i> Name:</strong></td>"
                + "<td>" + name + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-map-marker'></i> Address:</strong></td>"
                + "<td>" + address + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-envelope'></i> Email:</strong></td>"
                + "<td>" + email + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-phone'></i> Phone:</strong></td>"
                + "<td>" + phone + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-briefcase'></i> Position Applied:</strong></td>"
                + "<td>" + position + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-calendar'></i> Years of Experience:</strong></td>"
                + "<td>" + yearsOfExperience + "</td>"
                + "</tr>"
                + "<tr>"
                + "<td><strong><i class='fa fa-cogs'></i> Skills:</strong></td>"
                + "<td>" + skills + "</td>"
                + "</tr>"
                + "</table>";



        // Send email with attachment (useSecondaryEmail can be true or false based on your logic)
        emailService.sendEmailWithAttachment(
                "hr.wetechhub@gmail.com",  // Recipient's email
                subject,
                body,
                pdfFile.getBytes(),  // PDF file content
                pdfFile.getOriginalFilename(),  // PDF file name
                true  // Set to true to use secondary email sender
        );

        return savedApplicant;

    }


    // show from db to website
    public List<JobApplicant> getAllJobApplicant() {
        return (List<JobApplicant>) applicantRepository.findAll();
    }


    public byte[] downloadPdf(Long applicantId) {
        JobApplicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return applicant.getPdfFile();
    }


}


//    applicant er list edit or delete korar dorkar ken?

// delete by id

//    public void deleteJobPost(Integer id) {
//        jobPostingRepository.deleteById(id);
//    }
//
//
//    // edit
//    public JobPosting getJobPostById(Integer id) {
//        return jobPostingRepository.findById(id).get();
//    }
//
//    ;


//It works but not get pdf

//    //    create job
//    public JobApplicant applyForNewJob(JobApplicant jobApplicant) {
//
//        return applicantRepository.save(jobApplicant);
//    }   ;











//it works but i need more
//    public JobApplicant applyForNewJob(String name, String address, String email, String phone,
//                                       String position, Long yearsOfExperience, String skills,
//                                       MultipartFile pdfFile) throws IOException {
//        JobApplicant jobApplicant = new JobApplicant();
//        jobApplicant.setName(name);
//        jobApplicant.setAddress(address);
//        jobApplicant.setEmail(email);
//
//        jobApplicant.setPhone(phone);
//        jobApplicant.setPosition(position);
//        jobApplicant.setYearsOfExperience(yearsOfExperience);
//        jobApplicant.setSkills(skills);
//        jobApplicant.setPdfFile(pdfFile.getBytes());  // Convert file to bytes
//
//        return applicantRepository.save(jobApplicant);
//    }