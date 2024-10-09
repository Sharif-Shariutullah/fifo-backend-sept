package com.example.fifotech.repository;

import com.example.fifotech.entity.imageGB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageGBRepository extends JpaRepository<imageGB, Long> {

    @Modifying
    @Query(value = "DELETE FROM image_gb WHERE global_id = :globalBpoId", nativeQuery = true)
    void deleteByGlobalBpoId(@Param("globalBpoId") Long globalBpoId);
}
