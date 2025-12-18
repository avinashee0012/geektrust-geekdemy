package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.geektrust.model.Purchase;
import com.example.geektrust.model.dto.BillDto;
import com.example.geektrust.service.impl.BillServiceImpl;

public class BillServiceTest {

    @Test
    void shouldPrintBillCorrectly(){
        Purchase p = new Purchase();
        p.addCertifications(1);
        p.addDiplomas(2);

        BillService bs = new BillServiceImpl(p);
        BillDto bill = bs.printBill();

        assertTrue(bill.getSubtotal() > 0); 
    }
}
