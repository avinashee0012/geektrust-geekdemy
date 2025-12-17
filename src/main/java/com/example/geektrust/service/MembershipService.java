package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;

public class MembershipService {
    private final Purchase purchase;

    public MembershipService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void addProMembership() {
        purchase.setProMember(true);
    }
}
