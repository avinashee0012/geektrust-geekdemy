package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;

public class CouponService {
    private final Purchase purchase;

    public CouponService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void applyCoupon(CouponType applyingCoupon) {
        if (purchase.getCouponType() != CouponType.B4G1) {
            CouponType coupon = CouponType.NONE;

            if (purchase.calculateSubtotal() >= 10000) {
                int discountPerc = Math.max(applyingCoupon.getDiscountPercent(),
                        purchase.getCouponType().getDiscountPercent());
                switch (discountPerc) {
                    case 5:
                        coupon = CouponType.DEAL_G5;
                        break;
                    case 20:
                        coupon = CouponType.DEAL_G20;
                        break;
                    default:
                        break;
                }
            } else if (purchase.totalProgrammes() >= 2 && applyingCoupon == CouponType.DEAL_G5) {
                coupon = CouponType.DEAL_G5;
            }

            purchase.setCouponType(coupon);
        }
    }
}
