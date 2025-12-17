package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.model.enums.CouponType;
import com.example.geektrust.service.PurchaseService;

public class ApplyCouponCommand implements ICommand{
    private final PurchaseService purchaseService;

    private final int COUPON_IDX = 1;

    public ApplyCouponCommand(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            purchaseService.applyCoupon(CouponType.valueOf(tokens.get(COUPON_IDX)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
