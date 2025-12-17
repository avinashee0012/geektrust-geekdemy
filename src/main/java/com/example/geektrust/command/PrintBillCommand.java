package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.service.BillService;

public class PrintBillCommand implements ICommand{
    private final BillService billService;

    public PrintBillCommand(BillService billService) {
        this.billService = billService;
    }

    @Override
    public void execute(List<String> tokens) {
        billService.printBill();
    }
}
