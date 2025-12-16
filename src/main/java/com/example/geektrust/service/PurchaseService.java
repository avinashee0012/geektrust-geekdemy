package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.enums.ProgrammeType;

public class PurchaseService {
    private final Purchase purchase;

    public PurchaseService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void addProgramme(ProgrammeType programmeType, int qty) {
        purchase.setProgrammes(purchase.getProgrammes() + qty);
        purchase.setCheapest(Math.min(programmeType.getPrice(), purchase.getCheapest()));
        if (purchase.isProMember()) {
            int proDiscount = programmeType.getPrice() * qty * programmeType.getProDiscount() / 100;
            purchase.setTotalProDiscount(proDiscount);
            purchase.setSubtotal(purchase.getSubtotal() + programmeType.getPrice() * qty - proDiscount);
        } else {
            purchase.setSubtotal(purchase.getSubtotal() + programmeType.getPrice() * qty);
        }
    }
}
