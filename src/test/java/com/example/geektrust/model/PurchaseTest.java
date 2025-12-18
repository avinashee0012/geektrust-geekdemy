package com.example.geektrust.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    private Purchase p;

    @BeforeEach
    void setup(){
        p = new Purchase();
    }

    @Test
    void shouldUpdateCountOfCertificateProgrammes(){
        p.addCertifications(3);
        p.addCertifications(1);
        assertEquals(4, p.getCertifications());
    }

    @Test
    void shouldUpdateCountOfDegreeProgrammes(){
        p.addDegrees(3);
        p.addDegrees(2);
        assertEquals(5, p.getDegrees());
    }

    @Test
    void shouldUpdateCountOfDiplomaProgrammes(){
        p.addDiplomas(0);
        p.addDiplomas(5);
        assertEquals(5, p.getDiplomas());
    }
}
