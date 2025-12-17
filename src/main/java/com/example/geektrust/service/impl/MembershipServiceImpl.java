package com.example.geektrust.service.impl;

import com.example.geektrust.service.MembershipService;
import com.example.geektrust.service.PurchaseService;

public class MembershipServiceImpl implements MembershipService{
    private final PurchaseService purchaseService;

    public MembershipServiceImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public void addProMembership() {
        purchaseService.addPro(true);
    }
}
