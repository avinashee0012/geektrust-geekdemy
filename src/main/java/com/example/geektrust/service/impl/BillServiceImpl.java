package com.example.geektrust.service.impl;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.dto.BillDto;
import com.example.geektrust.service.BillService;

public class BillServiceImpl implements BillService{
    private final Purchase purchase;

    public BillServiceImpl(Purchase purchase) {
        this.purchase = purchase;
    }

    public BillDto printBill(){
        BillDto bill = purchase.getBill();
        System.out.println(String.format("SUB_TOTAL %.2f", bill.getSubtotal()));
        System.out.println(String.format("COUPON_DISCOUNT %s", bill.getCouponInfo()));
        System.out.println(String.format("TOTAL_PRO_DISCOUNT %.2f", bill.getProDiscount()));
        System.out.println(String.format("PRO_MEMBERSHIP_FEE %.2f", bill.getProMembershipFee()));
        System.out.println(String.format("ENROLLMENT_FEE %.2f", bill.getEnrollmentFee()));
        System.out.println(String.format("TOTAL %.2f", bill.getTotal()));
        return bill;
    }
}

