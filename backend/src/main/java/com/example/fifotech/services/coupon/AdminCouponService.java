package com.example.fifotech.services.coupon;

import com.example.fifotech.entity.Coupon;

import java.util.List;

public interface AdminCouponService {




    Coupon createCoupon (Coupon coupon);

    List<Coupon> getAllCoupons();
}
