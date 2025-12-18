package com.example.geektrust.service.impl;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{
    private final Purchase purchase;

    public PurchaseServiceImpl(Purchase purchase) {
        this.purchase = purchase;
    }

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
}
