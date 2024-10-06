package com.example.fifotech.services;

import com.example.fifotech.entity.Gallery;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;



//    //    create
//    public Gallery createNewGallery(Gallery gallery) throws IOException {
//
//        Gallery gallery1 = new Gallery();
//
//        gallery1.setTitle(gallery.getTitle());
//        gallery1.setSubtitle(gallery.getSubtitle());
//        gallery1.setDetails(gallery.getDetails());
//        gallery1.setCaption(gallery.getCaption());
//        gallery1.setPostDate(gallery.getPostDate());
////        gallery1.setImg(gallery.getMultiImg().getBytes());
//
//
//
//        return galleryRepository.save(gallery1);
//    }






    public Gallery saveGallery(String title, String subtitle, String details, List<String> captions, List<MultipartFile> images) throws IOException {
        Gallery gallery = new Gallery();
        gallery.setTitle(title);
        gallery.setSubtitle(subtitle);
        gallery.setPostDate(LocalDate.now());
        gallery.setDetails(details);
        gallery.setCaption(captions);

        // Convert images to byte[] and store
        List<byte[]> imageBytes = new ArrayList<>();
        for (MultipartFile image : images) {
            imageBytes.add(image.getBytes());
        }
        gallery.setImg(imageBytes);

        return galleryRepository.save(gallery);
    }



//    // Retrieve gallery by ID and convert images to Base64
//    public GalleryDTO getGallery(Long id) {
//        Gallery gallery = galleryRepository.findById(id).orElseThrow(() -> new RuntimeException("Gallery not found"));
//
//        // Convert images from byte[] to Base64 encoded strings
//        List<String> base64Images = gallery.getImg().stream()
//                .map(image -> Base64.getEncoder().encodeToString(image))
//                .collect(Collectors.toList());
//
//        // Create and return DTO (Data Transfer Object) with Base64 images
//        return new GalleryDTO(gallery.getTitle(), gallery.getSubtitle(), gallery.getDetails(), base64Images);
//    }











    //    create
    public Gallery createNewGallery(Gallery gallery) {

        return galleryRepository.save(gallery);
    }







    // show from db to website
    public List<Gallery> getAllGallery() {
        return (List<Gallery>) galleryRepository.findAll();
    }


    // delete by id

    public void deleteGallery(Long id) {
        galleryRepository.deleteById(id);
    }


    // edit
    public Gallery getGalleryById(Long id) {
        return galleryRepository.findById(id).get();
    }

}
