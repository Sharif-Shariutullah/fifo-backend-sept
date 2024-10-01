package com.example.fifotech.services;


import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.repository.ApplicantRepository;
import com.example.fifotech.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

//It works but not get pdf

//    //    create job
//    public JobApplicant applyForNewJob(JobApplicant jobApplicant) {
//
//        return applicantRepository.save(jobApplicant);
//    }   ;



    public JobApplicant applyForNewJob(String name, String address, String email, String phone,
                                       String position, Long yearsOfExperience, String skills,
                                       MultipartFile pdfFile) throws IOException {
        JobApplicant jobApplicant = new JobApplicant();
        jobApplicant.setName(name);
        jobApplicant.setAddress(address);
        jobApplicant.setEmail(email);
        jobApplicant.setPhone(phone);
        jobApplicant.setPosition(position);
        jobApplicant.setYearsOfExperience(yearsOfExperience);
        jobApplicant.setSkills(skills);
        jobApplicant.setPdfFile(pdfFile.getBytes());  // Convert file to bytes

        return applicantRepository.save(jobApplicant);
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


