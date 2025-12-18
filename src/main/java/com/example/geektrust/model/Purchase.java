package com.example.geektrust.model;

import com.example.geektrust.config.AppConstants;
import com.example.geektrust.model.dto.BillDto;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.model.enums.ProgrammeType;

public class Purchase {
    private int certifications;
    private int diplomas;
    private int degrees;
    private CouponType couponType;
    private boolean isProMember;

    // ************* CONSTRUCTORS *************
    public Purchase() {
        this.couponType = CouponType.NONE;
    }

    // ************* PUBLIC METHODS *************
    public void applyCoupon(CouponType applyingCoupon) {

        if (couponType == CouponType.B4G1)
            return;

        if(totalProgrammes() >= AppConstants.BUNDLE_THRESHOLD) {
            couponType = CouponType.B4G1;
            return;
        }

        CouponType coupon = CouponType.NONE;
        if (calculateSubtotal() >= AppConstants.G20_SUBTOTAL_THRESHOLD) {
            int bestDiscount = Math.max(applyingCoupon.getDiscountPercent(),
                    couponType.getDiscountPercent());
            coupon = (bestDiscount == CouponType.DEAL_G20.getDiscountPercent()) ? CouponType.DEAL_G20 : CouponType.DEAL_G5;
        } else if (totalProgrammes() >= AppConstants.G5_PROGRAMME_THRESHOLD && applyingCoupon == CouponType.DEAL_G5) {
            coupon = CouponType.DEAL_G5;
        }

        this.couponType = coupon;
    }

    public void activatePro(boolean isPro) {
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

    public BillDto getBill(){
        return new BillDto.Builder()
                                .subtotal(calculateSubtotal())
                                .couponInfo(getCouponInfo())
                                .enrollmentFee(calculateEnrollmentFee())
                                .proDiscount(calculateProDiscount())
                                .proMembershipFee(caculateProMembershipFee())
                                .total(caculateTotal())
                                .build();
    }

    // ************* HELPER METHODS *************
    private double calculateCouponDiscount() {
        switch (couponType) {
            case B4G1:
                return getCheapest() * CouponType.B4G1.getDiscountPercent() * AppConstants.DIVIDE_BY_HUNDRED;
            case DEAL_G20:
            case DEAL_G5:
                return calculateSubtotal() * couponType.getDiscountPercent() * AppConstants.DIVIDE_BY_HUNDRED;
            default:
                return 0;
        }
    }

    private double getCheapest() {
        ProgrammeType cheapestProgrammeType = findCheapestProgramme();
        return isProMember
                ? cheapestProgrammeType.getPrice() - cheapestProgrammeType.getPrice() * cheapestProgrammeType.getProDiscount() * AppConstants.DIVIDE_BY_HUNDRED
                : cheapestProgrammeType.getPrice();
    }

    private ProgrammeType findCheapestProgramme() {
        if (diplomas > 0)
            return ProgrammeType.DIPLOMA;
        if (certifications > 0)
            return ProgrammeType.CERTIFICATION;
        if (degrees > 0)
            return ProgrammeType.DEGREE;
        throw new IllegalArgumentException("No programmes found in purchase.");
    }

    private double caculateProMembershipFee() {
        return isProMember ? 200 : 0;
    }

    private double calculateProDiscount() {
        double discount = (certifications * ProgrammeType.CERTIFICATION.getPrice()
                    * ProgrammeType.CERTIFICATION.getProDiscount() * AppConstants.DIVIDE_BY_HUNDRED)
            + (degrees * ProgrammeType.DEGREE.getPrice() * ProgrammeType.DEGREE.getProDiscount()
                    * AppConstants.DIVIDE_BY_HUNDRED)
            + (diplomas * ProgrammeType.DIPLOMA.getPrice() * ProgrammeType.DIPLOMA.getProDiscount()
                    * AppConstants.DIVIDE_BY_HUNDRED);
        return isProMember ? discount : 0;
    }

    private double calculateSubtotal() {
        double subtotal = (certifications * ProgrammeType.CERTIFICATION.getPrice())
                + (degrees * ProgrammeType.DEGREE.getPrice()) + (diplomas * ProgrammeType.DIPLOMA.getPrice());
        subtotal -= calculateProDiscount();
        subtotal += caculateProMembershipFee();
        return subtotal;
    }

    private String getCouponInfo() {
        return String.format("%s %.2f", couponType.name(), calculateCouponDiscount());
    }

    private double calculateEnrollmentFee() {
        return (calculateSubtotal() < AppConstants.ENROLLMENT_FEE_THRESHOLD) ? AppConstants.ENROLLMENT_FEE : 0;
    }

    private double caculateTotal() {
        return calculateSubtotal() - calculateCouponDiscount() + calculateEnrollmentFee();
    }

    public int totalProgrammes() {
        return certifications + degrees + diplomas;
    }
    
    // GETTERS
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
    
}
