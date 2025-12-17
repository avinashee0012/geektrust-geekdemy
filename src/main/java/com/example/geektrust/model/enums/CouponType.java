package com.example.geektrust.model.enums;

public enum CouponType {
    DEAL_G20(20),
    DEAL_G5(5),
    B4G1(100),
    ZERO(0);

    private final int discountPercent;

    private CouponType(int discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    public int getDiscountPercent(){
        return discountPercent;
    }
}
