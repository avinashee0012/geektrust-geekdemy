package com.example.geektrust.model;

public class Purchase {
    private int programmes;
    private int cheapest;
    private double subtotal;
    private String coupon;
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

    public String getCoupon() {
        return coupon;
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

    public void setCoupon(String coupon) {
        this.coupon = coupon;
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
        System.out.println("SUB_TOTAL " + subtotal);
        System.out.println("COUPON_DISCOUNT " + coupon + " " + couponDiscount);
        System.out.println("TOTAL_PRO_DISCOUNT " + totalProDiscount);
        System.out.println("PRO_MEMBERSHIP_FEE " + proMembershipFee);
        double total = subtotal - couponDiscount;
        if(total < 6666) {
            enrollmentFee += 500;
            total += enrollmentFee;
        }
        System.out.println("ENROLLMENT_FEE " + enrollmentFee);
        System.out.println("TOTAL " + total);
    }
}
