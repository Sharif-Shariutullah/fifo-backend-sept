package com.example.fifotech.services.customer.review;

import com.example.fifotech.dto.OrderedProductResponseDto;
import com.example.fifotech.dto.ProductDto;
import com.example.fifotech.dto.ReviewDto;
import com.example.fifotech.entity.*;
import com.example.fifotech.repository.OrderRepository;
import com.example.fifotech.repository.ProductRepository;
import com.example.fifotech.repository.ReviewRepository;
import com.example.fifotech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;


    public OrderedProductResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        OrderedProductResponseDto orderedProductResponseDto = new OrderedProductResponseDto();
        if (optionalOrder.isPresent()) {
            orderedProductResponseDto.setOrderAmount(optionalOrder.get().getAmount());
            List<ProductDto> productotoList = new ArrayList<>();
            for (CartItems cartItems : optionalOrder.get().getCartItems()) {

                ProductDto productDto = new ProductDto();

                productDto.setId(cartItems.getProduct().getId());
                productDto.setName(cartItems.getProduct().getName());
                productDto.setPrice(cartItems.getPrice());
                productDto.setQuantity(cartItems.getQuantity());


                productDto.setByteImg(cartItems.getProduct().getImg());

                productotoList.add(productDto);
            }
            orderedProductResponseDto.setProductDtoList(productotoList);
        }
        return orderedProductResponseDto;
    }


    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());


        if (optionalProduct.isPresent() && optionalUser.isPresent()) {

            Review review = new Review();

            review.setRating(reviewDto.getRating());
            review.setDescription(reviewDto.getDescription());
            review.setUser(optionalUser.get());
            review.setProduct(optionalProduct.get());
            review.setImg(reviewDto.getImg().getBytes());

            return reviewRepository.save(review).getDto();
        }
        return null;
    }


}
