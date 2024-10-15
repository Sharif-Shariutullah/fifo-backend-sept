package com.example.fifotech.controller;

import com.example.fifotech.entity.GlobalBPO;
import com.example.fifotech.entity.imageGB;
import com.example.fifotech.services.GlobalBPOService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class GlobalBPOController {


    @Autowired
    private GlobalBPOService globalBPOService;

//    @PostMapping("/createGlobalBPO")
//    public ResponseEntity<GlobalBPO> createGlobalBPO(
//            @RequestParam("title") String title,
//            @RequestParam("subtitle") String subtitle,
//            @RequestParam("postDate") LocalDate postDate,
//            @RequestParam("details") String details,
//            @RequestParam("images") List<MultipartFile> files,
//            @RequestParam("captions") List<String> captions) throws IOException {
//
//        GlobalBPO globalBPO = new GlobalBPO();
//        globalBPO.setTitle(title);
//        globalBPO.setSubtitle(subtitle);
//        globalBPO.setPostDate(postDate);
//        globalBPO.setDetails(details);
//
//        GlobalBPO createdGlobalBPO = globalBPOService.createGlobalBPO(globalBPO, files, captions);
//        return ResponseEntity.ok(createdGlobalBPO);
//    }



    @PostMapping("/createGlobalBPO")
    public ResponseEntity<GlobalBPO> createGlobalBPO(
            @RequestParam("title") String title,
            @RequestParam("subtitle") String subtitle,
            @RequestParam("postDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate postDate,
            @RequestParam("details") String details,
            @RequestParam("captions") List<String> captions, // Captions list for each image
            @RequestParam("images") List<MultipartFile> images,  // Multiple images
            @RequestParam("thumbnailImage") MultipartFile thumbnailImage // New parameter for thumbnail

    ) throws IOException {

        GlobalBPO bpo = new GlobalBPO();
        bpo.setTitle(title);
        bpo.setSubtitle(subtitle);
        bpo.setPostDate(postDate);
        bpo.setDetails(details);

        // Set thumbnail image
        if (thumbnailImage != null && !thumbnailImage.isEmpty()) {
            bpo.setThumbnailImage(thumbnailImage.getBytes());
        }


        List<imageGB> postImages = new ArrayList<>();
        for (int i = 0; i < images.size(); i++) {

            MultipartFile imageFile = images.get(i);
            imageGB postImage = new imageGB();
            postImage.setImg(imageFile.getBytes());
            postImage.setCaption(captions.get(i)); // Add the corresponding caption
            postImages.add(postImage);
        }

        bpo.setImages(postImages);  // Attach images with captions to the post
        GlobalBPO savedPost = globalBPOService.createGlobalBPO(bpo);

        return ResponseEntity.ok(savedPost);
    }




    @GetMapping("/getAllGlobalBPOs")
    public ResponseEntity<List<GlobalBPO>> getAllGlobalBPOs() {
        List<GlobalBPO> globalBPOs = globalBPOService.getAllGlobalBPOs();
        return ResponseEntity.ok(globalBPOs);
    }







    @GetMapping("/getGlobalBPOById/{id}")
    public ResponseEntity<GlobalBPO> getGlobalBPOById(@PathVariable Long id) {
        return globalBPOService.getGlobalBPOById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateGlobalBPO/{id}")
    public ResponseEntity<GlobalBPO> updateGlobalBPO(@PathVariable Long id, @RequestBody GlobalBPO updatedGlobalBPO) {
        GlobalBPO globalBPO = globalBPOService.updateGlobalBPO(id, updatedGlobalBPO);
        return ResponseEntity.ok(globalBPO);
    }

    @DeleteMapping("/deleteGlobalBPO/{id}")
    public ResponseEntity<Void> deleteGlobalBPO(@PathVariable Long id) {
        globalBPOService.deleteGlobalBPO(id);
        return ResponseEntity.noContent().build();
    }






}


//
//// create
//@PostMapping({"/postNewGlobalBPO"})
//public GlobalBPO addNewGlobalBPO(@RequestBody GlobalBPO globalBPO) {
//    return globalBPOService.createNewGlobalBPO(globalBPO);
//
//}
//
//// show
//@GetMapping({"/getAllGlobalBPO"})
//public List<GlobalBPO> getAllGlobalBPO() {
//    return globalBPOService.getAllGlobalBPO();
//}
//
//;
//
//// delete
//@DeleteMapping({"/deleteGlobalBPO/{id}"})
//public void deleteGlobalBPO(@PathVariable("id") Integer id) {
//    globalBPOService.deleteGlobalBPO(id);
//}
//
////edit
//@GetMapping({"/getGlobalBPOById/{id}"})
//public GlobalBPO getGlobalBPOById(@PathVariable("id") Integer id) {
//    return globalBPOService.getGlobalBPOById(id);
//}
//
//;
//
