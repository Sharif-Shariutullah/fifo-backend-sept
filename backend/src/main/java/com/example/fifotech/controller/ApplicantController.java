package com.example.fifotech.controller;

import com.example.fifotech.entity.ImageModel;
import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ApplicantController {


    @Autowired
    private ApplicantService applicantService;


    // create
    @PostMapping({"/applyForNewJob"})
    public JobApplicant applyForNewJob(@RequestBody JobApplicant jobApplicant) {

        return applicantService.applyForNewJob(jobApplicant);

    }

    // show
    @GetMapping({"/getAllJobApplicant"})
    public List<JobApplicant> getAllJobApplicant() {
        return applicantService.getAllJobApplicant();
    }

    ;



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


}
