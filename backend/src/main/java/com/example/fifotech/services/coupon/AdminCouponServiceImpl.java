package com.example.fifotech.services.coupon;

import com.example.fifotech.entity.Coupon;
import com.example.fifotech.repository.CouponRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService{


//@Autowired
private final CouponRepository couponRepository;


    public Coupon createCoupon (Coupon coupon) {
        if(couponRepository.existsByCode(coupon.getCode())){
            throw new ValidationException("Coupon code already exists.");
        }
        return couponRepository.save(coupon);
    }


    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
