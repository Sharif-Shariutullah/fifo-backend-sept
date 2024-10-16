package com.example.fifotech.controller;

import com.example.fifotech.entity.Gallery;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.GalleryService;
import com.example.fifotech.services.JobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GalleryController {


    @Autowired
    private GalleryService galleryService;


    @PostMapping("/upload")
    public Gallery uploadGallery(
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("details") String details,
            @RequestParam("captions") List<String> captions,
            @RequestParam("images") List<MultipartFile> images) throws IOException {



        return galleryService.saveGallery(title, subtitle, details, captions, images);
    }




//
//    // show
//    @GetMapping({"/getAllGallery"})
//    public List<Gallery> getAllGallery() {
//        return galleryService.getAllGallery();
//    }
//
//    ;
//
//    // delete
//    @DeleteMapping({"/deleteGallery/{id}"})
//    public void deleteGallery(@PathVariable("id") Long id) {
//        galleryService.deleteGallery(id);
//    }
//
//    //Get Element by id to show
//    @GetMapping({"/getGalleryById/{id}"})
//    public Gallery getGalleryById(@PathVariable("id") Long id) {
//        return galleryService.getGalleryById(id);
//    } ;
//
//






    @GetMapping("/getAllGallery")
    public ResponseEntity<List<Gallery>> getAllGallery() {
        List<Gallery> galleries = galleryService.getAllGallery();
        return ResponseEntity.ok(galleries);
    }

    @DeleteMapping("/deleteGallery/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable("id") Long id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getGalleryById/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable("id") Long id) {
        Gallery gallery = galleryService.getGalleryById(id);
        return ResponseEntity.ok(gallery);
    }






    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }



}
