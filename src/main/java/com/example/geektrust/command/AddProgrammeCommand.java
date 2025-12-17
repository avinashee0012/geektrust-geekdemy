package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.PurchaseService;

public class AddProgrammeCommand implements ICommand{
    private final PurchaseService purchaseService;

    private final int PROG_TYPE_IDX = 1;
    private final int QTY_IDX = 2;

    public AddProgrammeCommand(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            purchaseService.addProgramme(ProgrammeType.valueOf(tokens.get(PROG_TYPE_IDX)), Integer.parseInt(tokens.get(QTY_IDX)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
