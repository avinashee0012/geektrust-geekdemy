package com.example.geektrust.service.impl;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.CouponService;

public class CouponServiceImpl implements CouponService{
    private final Purchase purchase;

    public CouponServiceImpl(Purchase purchase) {
        this.purchase = purchase;
    }

    public void applyCoupon(CouponType applyingCoupon) {
        purchase.applyCoupon(applyingCoupon);
    }

}
