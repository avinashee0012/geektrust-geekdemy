package com.example.geektrust.service;

import com.example.geektrust.model.enums.ProgrammeType;

public interface PurchaseService {
    void addProgramme(ProgrammeType programmeType, int qty);
}
