package com.example.fifotech.services;


import com.example.fifotech.entity.JobApplicant;
import com.example.fifotech.repository.ApplicantRepository;
import com.example.fifotech.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private FileRepository fileRepository;

    //    create job
    public JobApplicant applyForNewJob(JobApplicant jobApplicant) {


        return applicantRepository.save(jobApplicant);
    }

    ;


    // show from db to website
    public List<JobApplicant> getAllJobApplicant() {
        return (List<JobApplicant>) applicantRepository.findAll();
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


