package com.example.geektrust.model.dto;

public class BillDto {

    private final double subtotal;
    private final String couponInfo;
    private final double proDiscount;
    private final double proMembershipFee;
    private final double enrollmentFee;
    private final double total;

    private BillDto(Builder b) {
        this.subtotal = b.subtotal;
        this.couponInfo = b.couponInfo;
        this.proDiscount = b.proDiscount;
        this.proMembershipFee = b.proMembershipFee;
        this.enrollmentFee = b.enrollmentFee;
        this.total = b.total;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double subtotal;
        private String couponInfo;
        private double proDiscount;
        private double proMembershipFee;
        private double enrollmentFee;
        private double total;

        public Builder subtotal(double subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder couponInfo(String couponInfo) {
            this.couponInfo = couponInfo;
            return this;
        }

        public Builder proDiscount(double proDiscount) {
            this.proDiscount = proDiscount;
            return this;
        }

        public Builder proMembershipFee(double proMembershipFee) {
            this.proMembershipFee = proMembershipFee;
            return this;
        }

        public Builder enrollmentFee(double enrollmentFee) {
            this.enrollmentFee = enrollmentFee;
            return this;
        }

        public Builder total(double total) {
            this.total = total;
            return this;
        }

        public BillDto build() {
            return new BillDto(this);
        }
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getCouponInfo() {
        return couponInfo;
    }

    public double getProDiscount() {
        return proDiscount;
    }

    public double getProMembershipFee() {
        return proMembershipFee;
    }

    public double getEnrollmentFee() {
        return enrollmentFee;
    }

    public double getTotal() {
        return total;
    }

    
}
