package com.example.fifotech.services;

import com.example.fifotech.entity.Gallery;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;


    //    create
    public Gallery createNewGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    // show from db to website
    public List<Gallery> getAllGallery() {
        return (List<Gallery>) galleryRepository.findAll();
    }


    // delete by id

    public void deleteGallery(Integer id) {
        galleryRepository.deleteById(id);
    }


    // edit
    public Gallery getGalleryById(Integer id) {
        return galleryRepository.findById(id).get();
    }

}
