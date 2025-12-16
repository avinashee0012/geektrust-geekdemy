package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.model.Purchase;

public class PrintBillCommand implements ICommand{
    private final Purchase purchase;

    public PrintBillCommand(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public void execute(List<String> tokens) {
        purchase.printPurchase();
    }
}
