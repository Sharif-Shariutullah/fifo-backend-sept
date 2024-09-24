package com.example.fifotech.controller;

import com.example.fifotech.entity.Gallery;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.GalleryService;
import com.example.fifotech.services.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GalleryController {


    @Autowired
    private GalleryService galleryService;


    // create
    @PostMapping({"/postNewGallery"})
    public Gallery addNewGallery(@RequestBody Gallery gallery) {
        return galleryService.createNewGallery(gallery);
    }

    // show
    @GetMapping({"/getAllGallery"})
    public List<Gallery> getAllGallery() {
        return galleryService.getAllGallery();
    }

    ;

    // delete
    @DeleteMapping({"/deleteGallery/{id}"})
    public void deleteGallery(@PathVariable("id") Integer id) {
        galleryService.deleteGallery(id);
    }

    //edit
    @GetMapping({"/getGalleryById/{id}"})
    public Gallery getGalleryById(@PathVariable("id") Integer id) {
        return galleryService.getGalleryById(id);
    } ;

}
