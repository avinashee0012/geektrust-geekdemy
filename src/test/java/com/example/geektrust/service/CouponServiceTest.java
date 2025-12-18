package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.impl.CouponServiceImpl;

public class CouponServiceTest {
    
    @Test
    void shouldApplyG20Above10k(){
        Purchase p = new Purchase();
        CouponService cs = new CouponServiceImpl(p);
        p.addDegrees(3);
        cs.applyCoupon(CouponType.DEAL_G20);
        assertEquals("DEAL_G20", p.getCouponType().name());
    }

    @Test
    void shouldNotApplyG20Below10k(){
        Purchase p = new Purchase();
        CouponService cs = new CouponServiceImpl(p);
        p.addCertifications(3);
        cs.applyCoupon(CouponType.DEAL_G20);
        assertFalse("DEAL_G20".equals(p.getCouponType().name()));
    }
}
