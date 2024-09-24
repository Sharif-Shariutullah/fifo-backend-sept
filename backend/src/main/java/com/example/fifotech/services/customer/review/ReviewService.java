package com.example.fifotech.services.customer.review;

import com.example.fifotech.dto.OrderedProductResponseDto;
import com.example.fifotech.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {

    OrderedProductResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
