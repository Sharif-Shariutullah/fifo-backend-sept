package com.example.fifotech.repository;

import com.example.fifotech.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Long> {

    Optional<CartItems> findByProductIdAndOrderIdAndUserId(Long productId, Long orderID, Long userID);

    Optional<CartItems> findByProductIdAndUserId(Long productId, Long userId);
}
