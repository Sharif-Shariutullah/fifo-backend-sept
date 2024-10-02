package com.example.fifotech.controller;

import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;


    // create
    @PostMapping({"/postNewJob"})
    public JobPosting addNewJobPosting(@RequestBody JobPosting jobPosting) {

        return jobPostingService.postNewJob(jobPosting);

    }

    // show
    @GetMapping({"/getAllJobPosts"})
    public List<JobPosting> getAllJobPosts() {
        return jobPostingService.getAllJobPosts();
    }

    ;

    // delete
    @DeleteMapping({"/deleteJobPost/{id}"})
    public void deleteJobPost(@PathVariable("id") Long id) {
        jobPostingService.deleteJobPost(id);
    }

//    for DP
    @GetMapping({"/getJobPostById/{id}"})
    public JobPosting getJobPostById(@PathVariable("id") Long id) {

        return jobPostingService.getJobPostById(id);
    }

    ;

//    edit  >>  Update

    @PutMapping("/updateJobPost")
    public JobPosting updateJobPost(@RequestBody JobPosting jobPosting){
        return null;
    }



//    @PutMapping("/edit/{id}")
//    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
//        student.setId(id);
//        return service.update(student);
//    }


}
