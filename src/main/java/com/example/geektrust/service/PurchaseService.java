package com.example.geektrust.service;

import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.model.enums.ProgrammeType;

public interface PurchaseService {
    void addProgramme(ProgrammeType programmeType, int qty);
    double calculateSubtotal();
    String getCouponInfo();
    double calculateProDiscount();
    double caculateProMembershipFee();
    double calculateEnrollmentFee();
    double caculateTotal();
    void addPro(boolean isPro);
    void applyCoupon(CouponType applyingCoupon);
}
