package com.example.geektrust;

import com.example.geektrust.command.AddProMembershipCommand;
import com.example.geektrust.command.AddProgrammeCommand;
import com.example.geektrust.command.ApplyCouponCommand;
import com.example.geektrust.command.CommandInvoker;
import com.example.geektrust.command.PrintBillCommand;
import com.example.geektrust.config.AppConfig;
import com.example.geektrust.config.InputReader;
import com.example.geektrust.model.Purchase;
import com.example.geektrust.service.BillService;
import com.example.geektrust.service.CouponService;
import com.example.geektrust.service.MembershipService;
import com.example.geektrust.service.PurchaseService;
import com.example.geektrust.service.impl.BillServiceImpl;
import com.example.geektrust.service.impl.CouponServiceImpl;
import com.example.geektrust.service.impl.MembershipServiceImpl;
import com.example.geektrust.service.impl.PurchaseServiceImpl;

public class Main {
    public static void main(String[] args) {

        Purchase purchase = new Purchase();

        PurchaseService purchaseService = new PurchaseServiceImpl(purchase);
        MembershipService membershipService = new MembershipServiceImpl(purchase);
        BillService billService = new BillServiceImpl(purchase);
        CouponService couponService = new CouponServiceImpl(purchase);

        CommandInvoker commandInvoker = new CommandInvoker();

        commandInvoker.register("ADD_PROGRAMME", new AddProgrammeCommand(purchaseService));
        commandInvoker.register("APPLY_COUPON", new ApplyCouponCommand(couponService));
        commandInvoker.register("ADD_PRO_MEMBERSHIP", new AddProMembershipCommand(membershipService));
        commandInvoker.register("PRINT_BILL", new PrintBillCommand(billService));

        new AppConfig(commandInvoker, new InputReader()).process(args);
    }
}
