package com.example.fifotech.controller;

import com.example.fifotech.entity.ImageModel;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.entity.News;
import com.example.fifotech.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

public class NewsController {

    @Autowired
    private NewsService newsService;


    // create
//    @PostMapping({"/postNews"})
//    public News createNews(@RequestBody News news) {
//        return newsService.saveNews(news);
//    };


    //get all
    @GetMapping({"/getAllNews"})
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }


    // delete

    @DeleteMapping("/deleteNews{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
    }


    // get by id to do update
    @GetMapping("/editNews/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id);
    }




    // create with image   (learn yourself)

    @PostMapping(value = {"/postNews"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public News createNews(
                           @RequestParam("imageFile") MultipartFile[] file) {

        try {
            News news = new News();
            Set<ImageModel> images = uploadImage(file);
            news.setNewsImages(images);

            return newsService.saveNews(news);

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }

    };


    @PostMapping("/postNews2")
    public ResponseEntity<?> uploadImageToFIleSystem2(@RequestParam("image") MultipartFile[] file, @RequestParam("title") String title,
                                                      @RequestParam("content") String content, @RequestParam("author") String author,
                                                      @RequestParam("publishedAt") String publishedAt) throws IOException {
        String message = "";
        try {

            System.out.println(title + " " + content + " " + author + " " + publishedAt);
            LocalDateTime localDateTime = LocalDateTime.parse(publishedAt);
            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setAuthor(author);
            news.setPublishedAt(localDateTime);


            Set<ImageModel> images = uploadImage(file);
            news.setNewsImages(images);

            news = newsService.saveNews(news);

            return ResponseEntity.status(HttpStatus.OK).body(news);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }





    }


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



//    upload image in set

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );

            imageModels.add(imageModel);
        }
        return imageModels;
    }

    ;


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
