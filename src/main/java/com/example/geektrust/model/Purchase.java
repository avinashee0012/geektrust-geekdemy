package com.example.geektrust.model;

import com.example.geektrust.model.enums.CouponType;

public class Purchase {
    private int programmes;
    private int cheapest;
    private double subtotal;
    private CouponType couponType = CouponType.ZERO;
    private double couponDiscount;
    private boolean isProMember;
    private double proMembershipFee;
    private double totalProDiscount;
    private double enrollmentFee;

    public Purchase() {
    }

    public int getProgrammes() {
        return programmes;
    }

    public int getCheapest() {
        return cheapest;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public boolean isProMember() {
        return isProMember;
    }
    
    public double getProMembershipFee() {
        return proMembershipFee;
    }
    
    public double getTotalProDiscount() {
        return totalProDiscount;
    }
    
    public double getEnrollmentFee() {
        return enrollmentFee;
    }
    
    public void setProgrammes(int programmes) {
        this.programmes = programmes;
    }

    public void setCheapest(int cheapest) {
        this.cheapest = cheapest;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public void setProMember(boolean isProMember) {
        this.isProMember = isProMember;
    }

    public void setProMembershipFee(double proMembershipFee) {
        this.proMembershipFee = proMembershipFee;
    }

    public void setTotalProDiscount(double totalProDiscount) {
        this.totalProDiscount = totalProDiscount;
    }

    public void setEnrollmentFee(double enrollmentFee) {
        this.enrollmentFee = enrollmentFee;
    }

    public void printPurchase(){
        double total = subtotal - couponDiscount;
        if(total < 6666) {
            enrollmentFee += 500;
            total += enrollmentFee;
        }

        System.out.println(String.format("SUB_TOTAL %.2f", subtotal));
        System.out.println(String.format("COUPON_DISCOUNT %s %.2f", couponType, couponDiscount));
        System.out.println(String.format("TOTAL_PRO_DISCOUNT %.2f", totalProDiscount));
        System.out.println(String.format("PRO_MEMBERSHIP_FEE %.2f", proMembershipFee));
        System.out.println(String.format("ENROLLMENT_FEE %.2f", enrollmentFee));
        System.out.println(String.format("TOTAL %.2f", total));
    }
}
