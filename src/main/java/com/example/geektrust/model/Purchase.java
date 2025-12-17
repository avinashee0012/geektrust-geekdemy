package com.example.geektrust.model;

import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.model.enums.ProgrammeType;

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

    // ************* GETTERS & SETTERS *************
    public int getCertifications() {
        return certifications;
    }

    public void setCertifications(int certifications) {
        this.certifications = certifications;
    }

    public int getDiplomas() {
        return diplomas;
    }

    public void setDiplomas(int diplomas) {
        this.diplomas = diplomas;
    }

    public int getDegrees() {
        return degrees;
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
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

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public void setProMember(boolean isProMember) {
        this.isProMember = isProMember;
    }

    public void setEnrollmentFee(double enrollmentFee) {
        this.enrollmentFee = enrollmentFee;
    }

    // ************* PUBLIC METHODS *************
    public int totalProgrammes(){
        return certifications + degrees + diplomas;
    }

    public double calculateSubtotal(){
        if(totalProgrammes() >= 4){
            couponType = CouponType.B4G1;
        }
        double subtotal = 0;
        subtotal += (certifications * ProgrammeType.CERTIFICATION.getPrice());
        subtotal += (degrees * ProgrammeType.DEGREE.getPrice());
        subtotal += (diplomas * ProgrammeType.DIPLOMA.getPrice());
        subtotal -= calculateProDiscount();
        subtotal += caculateProMembershipFee();
        return subtotal;
    }
    
    public String getCouponInfo(){
        return String.format("%s %.2f", couponType.name(), calculateCouponDiscount());
    }

    public double calculateProDiscount(){
        double discount = 0;
        if (isProMember) {
            discount += (certifications * ProgrammeType.CERTIFICATION.getPrice() * ProgrammeType.CERTIFICATION.getProDiscount() / 100);
            discount += (degrees * ProgrammeType.DEGREE.getPrice() * ProgrammeType.DEGREE.getProDiscount() / 100); 
            discount += (diplomas * ProgrammeType.DIPLOMA.getPrice() * ProgrammeType.DIPLOMA.getProDiscount() / 100);  
        }
        return discount;
    }

    public double caculateProMembershipFee(){
        if (isProMember) {
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

    // ************* HELPER METHODS *************
    private double calculateCouponDiscount(){
        double discount = 0;
        switch (couponType) {
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
        if(isProMember){
            return cheapestProgrammeType.getPrice() * (1 - 1.0 * cheapestProgrammeType.getProDiscount() / 100);
        }
        // return 
        return cheapestProgrammeType.getPrice();
    }

    private ProgrammeType findCheapestProgramme() {
        if(diplomas > 0){
            return ProgrammeType.DIPLOMA;
        } else if(certifications > 0){
            return ProgrammeType.CERTIFICATION;
        } else if(degrees > 0){
            return ProgrammeType.DEGREE;
        } else {
            throw new IllegalArgumentException("Some exception occured");
        }
    }
}
