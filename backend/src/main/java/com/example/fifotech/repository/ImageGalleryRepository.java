package com.example.fifotech.repository;

import com.example.fifotech.entity.ImageGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageGalleryRepository extends JpaRepository<ImageGallery, Long> {

    @Modifying
    @Query(value = "DELETE FROM image_gallery WHERE gallery_id = :galleryId", nativeQuery = true)
    void deleteByGalleryId(@Param("galleryId") Long galleryId);
}
