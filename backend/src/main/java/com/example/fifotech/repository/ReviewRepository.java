package com.example.fifotech.repository;

import com.example.fifotech.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findALLByProductId(Long productsId);
}
