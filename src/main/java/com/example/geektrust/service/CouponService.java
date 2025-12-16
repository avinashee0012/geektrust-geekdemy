package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;

public class CouponService {
    private final Purchase purchase;

    public CouponService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void applyCoupon(CouponType couponType) {
        double discount = 0;
        
        if(purchase.getProgrammes() >= 4){
            discount = purchase.getCheapest(); // cheapest item free
            couponType = CouponType.B4G1;
        } else {
            switch (couponType) {
                case DEAL_G20:
                    if(purchase.getSubtotal() >= 10000){
                        couponType = CouponType.DEAL_G20;
                        discount = (purchase.getSubtotal() * couponType.getDiscountPercent() / 100); 
                    }
                    break;
                case DEAL_G5:
                    if (purchase.getProgrammes() >= 2) {
                        couponType = CouponType.DEAL_G5;
                        discount = (purchase.getSubtotal() * couponType.getDiscountPercent() / 100);
                    }
                    break;
                default:
                    break;
            }
        }

        if (discount > purchase.getCouponDiscount()) {
            purchase.setCoupon(couponType.name());
            purchase.setCouponDiscount(discount);
        }
    }
}

