package com.example.fifotech.services.wishlist;

import com.example.fifotech.dto.WishlistDto;
import com.example.fifotech.entity.Product;
import com.example.fifotech.entity.User;
import com.example.fifotech.entity.Wishlist;
import com.example.fifotech.repository.ProductRepository;
import com.example.fifotech.repository.UserRepository;
import com.example.fifotech.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImp implements WishlistService {


    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final WishlistRepository wishlistRepository;


    public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
        Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());
        if (optionalProduct.isPresent() && optionalUser.isPresent()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setProduct(optionalProduct.get());
            wishlist.setUser(optionalUser.get());

            return wishlistRepository.save(wishlist).getWishlistDto();


        }
        return null;
    }


    public List<WishlistDto> getWishlistByUserId(Long userId) {
        return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
    }


}
