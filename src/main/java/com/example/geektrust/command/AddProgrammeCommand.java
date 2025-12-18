package com.example.geektrust.command;

import java.util.List;

import com.example.geektrust.config.AppConstants;
import com.example.geektrust.model.enums.ProgrammeType;
import com.example.geektrust.service.PurchaseService;

public class AddProgrammeCommand implements ICommand{
    private final PurchaseService purchaseService;

    public AddProgrammeCommand(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public void execute(List<String> tokens) {
        try{
            purchaseService.addProgramme(ProgrammeType.valueOf(tokens.get(AppConstants.ONE)), Integer.parseInt(tokens.get(AppConstants.TWO)));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
