package com.example.geektrust.service.impl;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{
    private final Purchase purchase;

    public PurchaseServiceImpl(Purchase purchase) {
        this.purchase = purchase;
    }

    // ************* PUBLIC METHODS *************
    public void addProgramme(ProgrammeType programmeType, int qty) {
        switch (programmeType) {
            case CERTIFICATION:
                purchase.addCertifications(qty);
                break;
            case DEGREE:
                purchase.addDegrees(qty);
                break;
            case DIPLOMA:
                purchase.addDiplomas(qty);
                break;
            default:
                break;
        }
    }

    public double calculateSubtotal(){
        if(totalProgrammes() >= 4){
            purchase.addCoupon(CouponType.B4G1);;
        }
        double subtotal = 0;
        subtotal += (purchase.getCertifications() * ProgrammeType.CERTIFICATION.getPrice());
        subtotal += (purchase.getDegrees() * ProgrammeType.DEGREE.getPrice());
        subtotal += (purchase.getDiplomas() * ProgrammeType.DIPLOMA.getPrice());
        subtotal -= calculateProDiscount();
        subtotal += caculateProMembershipFee();
        return subtotal;
    }
    
    public String getCouponInfo(){
        return String.format("%s %.2f", purchase.getCouponType().name(), calculateCouponDiscount());
    }

    public double calculateProDiscount(){
        double discount = 0;
        if (purchase.isProMember()) {
            discount += (purchase.getCertifications() * ProgrammeType.CERTIFICATION.getPrice() * ProgrammeType.CERTIFICATION.getProDiscount() / 100);
            discount += (purchase.getDegrees() * ProgrammeType.DEGREE.getPrice() * ProgrammeType.DEGREE.getProDiscount() / 100); 
            discount += (purchase.getDiplomas() * ProgrammeType.DIPLOMA.getPrice() * ProgrammeType.DIPLOMA.getProDiscount() / 100);  
        }
        return discount;
    }

    public double caculateProMembershipFee(){
        if (purchase.isProMember()) {
            return 200;
        }
        return 0;
    }

    public double calculateEnrollmentFee(){
        int enrollmentFee = 0;
        if(calculateSubtotal() < 6666){
            enrollmentFee = 500;
        }
        return enrollmentFee;
    }

    public double caculateTotal(){
        return calculateSubtotal() - calculateCouponDiscount() + calculateEnrollmentFee();
    }

    public void addPro(boolean isPro) {
        purchase.addPro(isPro);
    }

    public void applyCoupon(CouponType applyingCoupon) {
        if (purchase.getCouponType() != CouponType.B4G1) {
            CouponType coupon = CouponType.NONE;

            if (calculateSubtotal() >= 10000) {
                int discountPerc = Math.max(applyingCoupon.getDiscountPercent(),
                        purchase.getCouponType().getDiscountPercent());
                switch (discountPerc) {
                    case 5:
                        coupon = CouponType.DEAL_G5;
                        break;
                    case 20:
                        coupon = CouponType.DEAL_G20;
                        break;
                    default:
                        break;
                }
            } else if (totalProgrammes() >= 2 && applyingCoupon == CouponType.DEAL_G5) {
                coupon = CouponType.DEAL_G5;
            }

            purchase.addCoupon(coupon);
        }
    }
    
    
    // ************* HELPER METHODS *************
    private double calculateCouponDiscount(){
        double discount = 0;
        switch (purchase.getCouponType()) {
            case B4G1:
                discount = getCheapest() * CouponType.B4G1.getDiscountPercent() / 100;
                break;
            case DEAL_G20:
                discount = calculateSubtotal() * CouponType.DEAL_G20.getDiscountPercent() / 100;
                break;
            case DEAL_G5:
                discount = calculateSubtotal() * CouponType.DEAL_G5.getDiscountPercent() / 100;
                break;
            default:
                break;
        }
        return discount;
    }

    private double getCheapest(){
        // find cheapest
        ProgrammeType cheapestProgrammeType = findCheapestProgramme();
        // apply pro discount
        if(purchase.isProMember()){
            return cheapestProgrammeType.getPrice() * (1 - 1.0 * cheapestProgrammeType.getProDiscount() / 100);
        }
        // return 
        return cheapestProgrammeType.getPrice();
    }

    private ProgrammeType findCheapestProgramme() {
        if(purchase.getDiplomas() > 0){
            return ProgrammeType.DIPLOMA;
        } else if(purchase.getCertifications() > 0){
            return ProgrammeType.CERTIFICATION;
        } else if(purchase.getDegrees() > 0){
            return ProgrammeType.DEGREE;
        } else {
            throw new IllegalArgumentException("No programmes found in purchase.");
        }
    }

    private int totalProgrammes(){
        return purchase.getCertifications() + purchase.getDegrees() + purchase.getDiplomas();
    }

}
