package com.example.fifotech.controller;

import com.example.fifotech.entity.*;
import com.example.fifotech.services.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GalleryController {


    @Autowired
    private GalleryService galleryService;


    @PostMapping("/createGallery")
    public ResponseEntity<Gallery> createGallery(
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("postDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate postDate,
            @RequestParam("details") String details,
            @RequestParam("captions") List<String> captions, // Captions list for each image
            @RequestParam("images") List<MultipartFile> images,  // Multiple images
            @RequestParam("thumbnailImage") MultipartFile thumbnailImage // New parameter for thumbnail

    ) throws IOException {

        Gallery gallery = new Gallery();
        gallery.setTitle(title);
        gallery.setSubtitle(subtitle);
        gallery.setPostDate(postDate);
        gallery.setDetails(details);

        // Set thumbnail image
        if (thumbnailImage != null && !thumbnailImage.isEmpty()) {
            gallery.setThumbnailImage(thumbnailImage.getBytes());
        }


        List<ImageGallery> postImages = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {

            MultipartFile imageFile = images.get(i);
            ImageGallery postImage = new ImageGallery();
            postImage.setImg(imageFile.getBytes());
            postImage.setCaption(captions.get(i)); // Add the corresponding caption
            postImages.add(postImage);
        }

        gallery.setImages(postImages);  // Attach images with captions to the post

        Gallery savedPost = galleryService.saveGallery(gallery);
        System.out.println("Received Captions: " + captions);

        return ResponseEntity.ok(savedPost);

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
    public ResponseEntity<Void> deleteGallery(@PathVariable Long id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping("/updateGallery/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable Long id, @RequestBody Gallery updatedGallery) {
        Gallery gallery = galleryService.updateGallery(id, updatedGallery);
        return ResponseEntity.ok(gallery);
    }




    @GetMapping("/getGalleryById/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable Long id) {
        return galleryService.getGalleryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }






    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }



}
