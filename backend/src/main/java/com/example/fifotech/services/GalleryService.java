package com.example.fifotech.services;

import com.example.fifotech.entity.Gallery;
import com.example.fifotech.repository.GalleryRepository;
import com.example.fifotech.repository.ImageGalleryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private ImageGalleryRepository imageGalleryRepository;


    public Gallery saveGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    // show from db to website
    public List<Gallery> getAllGallery() {
        return galleryRepository.findAll();
    }


    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
    }

    @Transactional
    public Gallery updateGallery(Long id, Gallery updatedGallery) {
        return galleryRepository.findById(id)
                .map(gallery -> {
                    gallery.setThumbnailImage(updatedGallery.getThumbnailImage());
                    gallery.setTitle(updatedGallery.getTitle());
                    gallery.setSubtitle(updatedGallery.getSubtitle());
                    gallery.setPostDate(updatedGallery.getPostDate());
                    gallery.setDetails(updatedGallery.getDetails());
                    gallery.setImages(updatedGallery.getImages()); // Update images if needed
                    return galleryRepository.save(gallery);
                })
                .orElseThrow(() -> new RuntimeException("gallery not found with id " + id));
    }


    // delete by id
    @Transactional
    public void deleteGallery(Long id) {
        galleryRepository.deleteById(id);

        imageGalleryRepository.deleteByGalleryId(id);
    }




}
