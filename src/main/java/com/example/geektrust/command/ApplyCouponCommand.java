package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.config.AppConstants;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.CouponService;

public class ApplyCouponCommand implements ICommand{
    private final CouponService couponService;

    public ApplyCouponCommand(CouponService couponService) {
        this.couponService = couponService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            couponService.applyCoupon(CouponType.valueOf(tokens.get(AppConstants.ONE)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
