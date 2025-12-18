package com.example.geektrust.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.AppConstants;
import com.example.geektrust.model.dto.BillDto;
import com.example.geektrust.model.enums.CouponType;

public class PurchaseTest {

    private Purchase p;

    @BeforeEach
    void setup() {
        p = new Purchase();
    }

    @Test
    void shouldUpdateCountOfCertificateProgrammes() {
        p.addCertifications(3);
        p.addCertifications(1);
        assertEquals(4, p.getCertifications());
    }

    @Test
    void shouldUpdateCountOfDegreeProgrammes() {
        p.addDegrees(3);
        p.addDegrees(2);
        assertEquals(5, p.getDegrees());
    }

    @Test
    void shouldUpdateCountOfDiplomaProgrammes() {
        p.addDiplomas(0);
        p.addDiplomas(5);
        assertEquals(5, p.getDiplomas());
    }

    @Test
    void shouldReturnProMemberYes() {
        p.activatePro(true);
        assertTrue(p.isProMember());
    }

    @Test
    void shouldApplyEnrollmentFeeWhenSubtotalLow() {
        p.addCertifications(1);
        BillDto bill = p.getBill();
        assertEquals(AppConstants.ENROLLMENT_FEE, bill.getEnrollmentFee());
    }

    @Test
    void shouldNotApplyEnrollmentFeeWhenSubtotalHigh() {
        p.addDegrees(2);
        BillDto bill = p.getBill();
        assertEquals(0, bill.getEnrollmentFee());
    }

    @Test
    void shouldUseCheapestProgrammeForB4G1Discount() {
        p.addDegrees(1);
        p.addDiplomas(4);
        p.applyCoupon(CouponType.DEAL_G20);
        BillDto bill = p.getBill();
        assertEquals("2500.00", bill.getCouponInfo().split(" ")[1]);
    }
}
