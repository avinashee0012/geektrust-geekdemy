package com.example.geektrust.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.command.AddProMembershipCommand;
import com.example.geektrust.command.AddProgrammeCommand;
import com.example.geektrust.command.ApplyCouponCommand;
import com.example.geektrust.command.CommandInvoker;
import com.example.geektrust.command.PrintBillCommand;
import com.example.geektrust.model.Purchase;
import com.example.geektrust.service.CouponService;
import com.example.geektrust.service.MembershipService;
import com.example.geektrust.service.PurchaseService;

public class AppConfig {  
    
    private final CommandInvoker commandInvoker;
    
    public AppConfig(CommandInvoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public void setup(){
        Purchase purchase = new Purchase();

        PurchaseService purchaseService = new PurchaseService(purchase);
        CouponService couponService = new CouponService(purchase);
        MembershipService membershipService = new MembershipService(purchase);

        AddProgrammeCommand addProgrammeCommand = new AddProgrammeCommand(purchaseService);
        ApplyCouponCommand applyCouponCommand = new ApplyCouponCommand(couponService);
        AddProMembershipCommand addProMembershipCommand = new AddProMembershipCommand(membershipService);
        PrintBillCommand printBillCommand = new PrintBillCommand(purchase);

        commandInvoker.register("ADD_PROGRAMME", addProgrammeCommand);
        commandInvoker.register("APPLY_COUPON", applyCouponCommand);
        commandInvoker.register("ADD_PRO_MEMBERSHIP", addProMembershipCommand);
        commandInvoker.register("PRINT_BILL", printBillCommand);
    }

    public void process(String[] args){
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            while (sc.hasNextLine()) {
                List<String> tokens = Arrays.asList(sc.nextLine().split(" "));
                String commandName = tokens.get(0);
                commandInvoker.invoke(commandName, tokens);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
