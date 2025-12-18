package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.impl.PurchaseServiceImpl;

public class PurchaseServiceTest {

    private Purchase p;
    private PurchaseService ps;

    @BeforeEach
    void setup(){
        p = new Purchase();
        ps = new PurchaseServiceImpl(p);
    }
    
    @Test
    void shouldAddCertificateToPurchase(){
        ps.addProgramme(ProgrammeType.CERTIFICATION, 2);
        assertTrue(p.getCertifications() == 2);
    }

    @Test
    void shouldAddB4G1ForMoreThan3Programmes(){
        ps.addProgramme(ProgrammeType.CERTIFICATION, 2);
        ps.addProgramme(ProgrammeType.DEGREE, 3);
        p.applyCoupon(CouponType.DEAL_G5);
        assertTrue("B4G1".equals(p.getCouponType().name()));
    }
}
