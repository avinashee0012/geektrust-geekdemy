package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;

public class BillService {
    private final Purchase purchase;

    public BillService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void printBill(){
        System.out.println(String.format("SUB_TOTAL %.2f", purchase.calculateSubtotal()));
        System.out.println(String.format("COUPON_DISCOUNT %s", purchase.getCouponInfo()));
        System.out.println(String.format("TOTAL_PRO_DISCOUNT %.2f", purchase.calculateProDiscount()));
        System.out.println(String.format("PRO_MEMBERSHIP_FEE %.2f", purchase.caculateProMembershipFee()));
        System.out.println(String.format("ENROLLMENT_FEE %.2f", purchase.calculateEnrollmentFee()));
        System.out.println(String.format("TOTAL %.2f", purchase.caculateTotal()));
    }
}

