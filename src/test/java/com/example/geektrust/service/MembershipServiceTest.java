package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.service.impl.MembershipServiceImpl;

public class MembershipServiceTest {
    
    @Test
    void shouldApplyProDiscountWhenProMember() {
        Purchase p = new Purchase();
        MembershipService ms = new MembershipServiceImpl(p);
        p.addCertifications(1);
        ms.addProMembership();
        double proMembershipFee = p.getBill().getProMembershipFee();
        assertEquals(200, proMembershipFee);
    }
}
