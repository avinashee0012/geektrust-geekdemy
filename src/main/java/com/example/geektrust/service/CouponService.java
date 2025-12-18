package com.example.geektrust.service;

import com.example.geektrust.model.enums.CouponType;

public interface CouponService {
    void applyCoupon(CouponType applyingCoupon);
}
