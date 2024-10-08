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


    // show from db to website
    public List<Gallery> getAllGallery() {
        return (List<Gallery>) galleryRepository.findAll();
    }


    // delete by id

    public void deleteGallery(Long id) {
        galleryRepository.deleteById(id);
    }


    //Get Element by id to show
    public Gallery getGalleryById(Long id) {
        return galleryRepository.findById(id).get();
    }

}
