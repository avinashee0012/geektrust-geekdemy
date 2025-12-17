package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.CouponService;

public class ApplyCouponCommand implements ICommand{
    private final CouponService couponService;

    private final int COUPON_IDX = 1;

    public ApplyCouponCommand(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            couponService.applyCoupon(CouponType.valueOf(tokens.get(COUPON_IDX)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
