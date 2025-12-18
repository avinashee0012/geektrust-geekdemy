package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.impl.PurchaseServiceImpl;

public class PurchaseServiceTest {
    
    @Test
    void shouldAddCertificateToPurchase(){
        Purchase p = new Purchase();
        PurchaseService ps = new PurchaseServiceImpl(p);

        ps.addProgramme(ProgrammeType.CERTIFICATION, 2);
        ps.addProgramme(ProgrammeType.DIPLOMA, 3);
        ps.addProgramme(ProgrammeType.DEGREE, 7);

        assertAll(
            () -> assertTrue(p.getCertifications() == 2),
            () -> assertEquals("B4G1", p.getCouponType().name())
        );
    }
}
