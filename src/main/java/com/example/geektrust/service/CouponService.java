package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;

public class CouponService {
    private final Purchase purchase;

    public CouponService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void applyCoupon(CouponType applyingCoupon) {
        // TODO incorrect response

        if (purchase.getCouponType() != CouponType.B4G1) {
            CouponType coupon = null;
            double discount = 0;

            if (purchase.getSubtotal() >= 10000) {
                int discountPerc = Math.max(applyingCoupon.getDiscountPercent(),
                        purchase.getCouponType().getDiscountPercent());
                switch (discountPerc) {
                    case 5:
                        coupon = CouponType.DEAL_G5;
                        discount = purchase.getSubtotal() * coupon.getDiscountPercent() / 100;
                        break;
                    case 20:
                        coupon = CouponType.DEAL_G20;
                        discount = purchase.getSubtotal() * coupon.getDiscountPercent() / 100;
                        break;
                    default:
                        break;
                }
            } else if (purchase.getProgrammes() >= 2 && applyingCoupon == CouponType.DEAL_G5) {
                coupon = CouponType.DEAL_G5;
            }
            
            purchase.setCouponType(coupon);
            purchase.setCouponDiscount(discount);
        }

    }
}
