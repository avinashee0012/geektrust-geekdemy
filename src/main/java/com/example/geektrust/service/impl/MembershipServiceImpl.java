package com.example.geektrust.service.impl;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.service.MembershipService;

public class MembershipServiceImpl implements MembershipService{
    private final Purchase purchase;

    public MembershipServiceImpl(Purchase purchase) {
        this.purchase = purchase;
    }

    public void addProMembership() {
        purchase.activatePro(true);
    }

}
