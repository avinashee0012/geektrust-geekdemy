package com.example.geektrust.service;

import com.example.geektrust.model.Purchase;

public class MembershipService {
    private final Purchase purchase;
    private final int PRO_FEE = 200;

    public MembershipService(Purchase purchase) {
        this.purchase = purchase;
    }

    public void addProMembership(){
        // ASSUMING:
            // Pro will be taken before adding programmes
            // No instance of pro for a pro member
        purchase.setProMember(true);
        purchase.setProMembershipFee(PRO_FEE);
        purchase.setSubtotal(purchase.getSubtotal() + PRO_FEE);
    }
}
