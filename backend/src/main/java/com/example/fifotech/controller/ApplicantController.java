package com.example.fifotech.controller;

import com.example.fifotech.entity.FileEntity;
import com.example.fifotech.entity.ImageModel;
import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.ApplicantService;
import com.example.fifotech.services.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.Console;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ApplicantController {


    //    private static final Logger log = LoggerFactory.getLogger(ApplicantController.class);
    @Autowired
    private ApplicantService applicantService;




    // create
//    @PostMapping({"/applyForNewJob"})
//    public JobApplicant applyForNewJob(@RequestBody JobApplicant jobApplicant) {
//
//        return applicantService.applyForNewJob(jobApplicant);
//
//    }



    // Create new applicant with PDF upload
    @PostMapping("/applyForNewJob")
    public JobApplicant applyForNewJob(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("position") String position,
            @RequestParam("yearsOfExperience") Long yearsOfExperience,
            @RequestParam("skills") String skills,
            @RequestParam("pdfFile") MultipartFile pdfFile) throws IOException {

        return applicantService.applyForNewJob(name, address, email, phone, position, yearsOfExperience, skills, pdfFile);
    }















    // show
    @GetMapping({"/getAllJobApplicant"})
    public List<JobApplicant> getAllJobApplicant() {
        return applicantService.getAllJobApplicant();
    }

    ;







    // Download PDF file by applicant ID
    @GetMapping("/downloadPdf/{applicantId}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long applicantId) {
        byte[] pdfData = applicantService.downloadPdf(applicantId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"applicant_resume.pdf\"")
                .body(pdfData);
    }













}


//    @PostMapping(value = "/applyForNewJob", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<JobApplicant> applyForNewJob(
//            @RequestPart("jobApplicant") String jobApplicantJson,
//            @RequestPart("file") MultipartFile file) throws IOException {
//
//        try {
//            // Convert jobApplicantJson to JobApplicant object
//            ObjectMapper objectMapper = new ObjectMapper();
//            JobApplicant jobApplicant = objectMapper.readValue(jobApplicantJson, JobApplicant.class);
//
//            // Save the resume
//            FileEntity savedFile = fileService.saveFile(file);
////            jobApplicant.setResume(savedFile);
//
//            // Save the applicant details
//            JobApplicant savedApplicant = applicantService.applyForNewJob(jobApplicant);
//            return ResponseEntity.ok(savedApplicant);
//
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//


// create
//    @PostMapping({"/applyForNewJob"})  //old

//    @PostMapping(value = "/applyForNewJob", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<JobApplicant> applyForNewJob(
//            @RequestPart("jobApplicant") String jobApplicantJson,
//            @RequestPart("file") MultipartFile file) throws IOException {
//
//
//        try {
//
//            // Parse the JSON string into a JobApplicant object
//            ObjectMapper objectMapper = new ObjectMapper();
//            JobApplicant jobApplicant = objectMapper.readValue(jobApplicantJson, JobApplicant.class);
//
//            // 1st save the file and set it to applicant
//            FileEntity savedFile = fileService.saveFile(file);
//            jobApplicant.setFile(savedFile);
//
//            // 2nd save row data
//            JobApplicant savedApplicant = applicantService.applyForNewJob(jobApplicant);
//            return ResponseEntity.ok(savedApplicant);
//
//
//        } catch (IOException e) {
//            System.out.println(" exception got-------" + e);
//            return ResponseEntity.status(500).body(null);
//
//        }
//
//
//    }


//    // create with image


//    @PostMapping(value = {"/applyForNewJob"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public JobApplicant applyForNewJob(@RequestPart("jobApplicant") JobApplicant jobApplicant,
//                                       @RequestPart("imageFile") MultipartFile[] file) {
//
//
//        try {
//            Set<ImageModel> images = uploadImage(file);
//            jobApplicant.setApplicantImages(images);
//
//            return applicantService.applyForNewJob(jobApplicant);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//            return null;
//        }
//     }
//
//    ;
//
//
////    upload image in set
//
//    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
//
//        Set<ImageModel> imageModels = new HashSet<>();
//        for (MultipartFile file : multipartFiles) {
//            ImageModel imageModel = new ImageModel(
//                    file.getOriginalFilename(),
//                    file.getContentType(),
//                    file.getBytes()
//            );
//            imageModels.add(imageModel);
//        }
//        return imageModels;
//    }
//
//    ;


//    // delete
//    @DeleteMapping({"/deleteJobPost/{id}"})
//    public void deleteJobPost(@PathVariable("id") Integer id) {
//        jobPostingService.deleteJobPost(id);
//    }
//
//    //edit
//    @GetMapping({"/getJobPostById/{id}"})
//    public JobPosting getJobPostById(@PathVariable("id") Integer id) {
//
//        return jobPostingService.getJobPostById(id);
//    } ;


