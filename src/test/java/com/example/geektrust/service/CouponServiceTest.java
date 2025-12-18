package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.impl.CouponServiceImpl;

public class CouponServiceTest {

    private Purchase p;
    private CouponService cs;

    @BeforeEach
    void setup(){
        p = new Purchase();
        cs = new CouponServiceImpl(p);
    }
    
    @Test
    void shouldApplyG20Above10k(){
        p.addDegrees(3);
        cs.applyCoupon(CouponType.DEAL_G20);
        assertEquals("DEAL_G20", p.getCouponType().name());
    }

    @Test
    void shouldNotApplyG20Below10k(){
        p.addCertifications(3);
        cs.applyCoupon(CouponType.DEAL_G20);
        assertFalse("DEAL_G20".equals(p.getCouponType().name()));
    }

    @Test
    void shouldApplyG5Above1ProgrammeOnly(){
        p.addDegrees(2);
        cs.applyCoupon(CouponType.DEAL_G5);
        assertEquals("DEAL_G5", p.getCouponType().name());
    }

    @Test
    void shouldNotApplyG5Below2Programmes(){
        p.addCertifications(1);
        cs.applyCoupon(CouponType.DEAL_G5);
        assertFalse("DEAL_G5".equals(p.getCouponType().name()));
    }
}
