package com.example.geektrust.service.impl;

import com.example.geektrust.service.BillService;
import com.example.geektrust.service.PurchaseService;

public class BillServiceImpl implements BillService{
    private final PurchaseService purchaseService;

    public BillServiceImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public void printBill(){
        System.out.println(String.format("SUB_TOTAL %.2f", purchaseService.calculateSubtotal()));
        System.out.println(String.format("COUPON_DISCOUNT %s", purchaseService.getCouponInfo()));
        System.out.println(String.format("TOTAL_PRO_DISCOUNT %.2f", purchaseService.calculateProDiscount()));
        System.out.println(String.format("PRO_MEMBERSHIP_FEE %.2f", purchaseService.caculateProMembershipFee()));
        System.out.println(String.format("ENROLLMENT_FEE %.2f", purchaseService.calculateEnrollmentFee()));
        System.out.println(String.format("TOTAL %.2f", purchaseService.caculateTotal()));
    }
}

