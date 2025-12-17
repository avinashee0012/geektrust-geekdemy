package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.ProgrammeType;

public class PurchaseService {
    private final Purchase purchase;

    public PurchaseService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void addProgramme(ProgrammeType programmeType, int qty) {
        switch (programmeType) {
            case CERTIFICATION:
                purchase.setCertifications(purchase.getCertifications() + qty);
                break;
            case DEGREE:
                purchase.setDegrees(purchase.getDegrees() + qty);
                break;
            case DIPLOMA:
                purchase.setDiplomas(purchase.getDiplomas() + qty);
                break;
            default:
                break;
        }
    }
}
