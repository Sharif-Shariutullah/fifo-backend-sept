package com.example.fifotech.services.wishlist;

import com.example.fifotech.dto.WishlistDto;

import java.util.List;

public interface WishlistService {


    WishlistDto addProductToWishlist (WishlistDto wishlistDto);

    public List<WishlistDto> getWishlistByUserId(Long userId);
}
