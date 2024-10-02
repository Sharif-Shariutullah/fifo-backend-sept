package com.example.fifotech.services;

import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    //    create
    public JobPosting postNewJob(JobPosting jobPosting) {

        return jobPostingRepository.save(jobPosting);
    }

    // show from db to website
    public List<JobPosting> getAllJobPosts() {
        return (List<JobPosting>) jobPostingRepository.findAll();

    }


    // delete by id
    public void deleteJobPost(Long id) {
        jobPostingRepository.deleteById(id);
    }


    // edit & Details page
    public JobPosting getJobPostById(Long id) {
        return jobPostingRepository.findById(id).get();
    }

    ;



//
//    public Student update(Student student) {
//        return repository.save(student);
//    }



}
