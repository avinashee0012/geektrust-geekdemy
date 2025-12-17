package com.example.geektrust.model;

import com.example.geektrust.model.enums.CouponType;

public class Purchase {
    private int certifications = 0;
    private int diplomas = 0;
    private int degrees = 0;
    private CouponType couponType = CouponType.NONE;
    private boolean isProMember = false;
    private double enrollmentFee = 0;

    // ************* CONSTRUCTORS *************
    public Purchase() {
    }

    // ************* GETTERS *************
    public int getCertifications() {
        return certifications;
    }

    public int getDiplomas() {
        return diplomas;
    }

    public int getDegrees() {
        return degrees;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public boolean isProMember() {
        return isProMember;
    }

    public double getEnrollmentFee() {
        return enrollmentFee;
    }

    // ************* PUBLIC METHODS *************
    public void addCoupon(CouponType couponType) {
        this.couponType = couponType;
    }

    public void addPro(boolean isPro){
        this.isProMember = isPro;
    }


    public void addCertifications(int qty) {
        this.certifications += qty;
    }

    public void addDegrees(int qty) {
        this.degrees += qty;
    }

    public void addDiplomas(int qty) {
        this.diplomas += qty;
    }

}
