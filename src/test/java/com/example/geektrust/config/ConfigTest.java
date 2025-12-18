package com.example.geektrust.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.geektrust.command.AddProgrammeCommand;
import com.example.geektrust.command.ApplyCouponCommand;
import com.example.geektrust.command.CommandInvoker;
import com.example.geektrust.model.Purchase;
import com.example.geektrust.service.CouponService;
import com.example.geektrust.service.PurchaseService;
import com.example.geektrust.service.impl.CouponServiceImpl;
import com.example.geektrust.service.impl.PurchaseServiceImpl;

public class ConfigTest {

    @Test
    void firstCommandForSample1ShouldBeAddProMembership(){
        String filePath = "sample_input/input1.txt";
        assertEquals("ADD_PRO_MEMBERSHIP", new InputReader().read(filePath).get(0).get(0));
    }

    @Test
    void shouldReturnPrintBillCommand(){
        Purchase p = new Purchase();
        PurchaseService purchaseService = new PurchaseServiceImpl(p);
        CouponService couponService = new CouponServiceImpl(p);

        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.register("ADD_PROGRAMME", new AddProgrammeCommand(purchaseService));
        commandInvoker.register("APPLY_COUPON", new ApplyCouponCommand(couponService));
        
        assertTrue(commandInvoker.get("APPLY_COUPON") instanceof ApplyCouponCommand);
    }

    @Test
    void shouldThrowExceptionForInvalidProgrammeType(){
        Purchase p = new Purchase();
        CouponService couponService = new CouponServiceImpl(p);
        ApplyCouponCommand ac = new ApplyCouponCommand(couponService);
        List<String> tokens = Arrays.asList("APPLY_COUPON", "DEAL_G50");
        assertThrows(IllegalArgumentException.class, () -> {
            ac.execute(tokens);
        });
    }

    @Test
    void shouldReturnTrueUponConstantsVerification(){
        assertEquals(4, AppConstants.BUNDLE_THRESHOLD);
        assertEquals(0.01, AppConstants.DIVIDE_BY_HUNDRED);
        assertEquals(500, AppConstants.ENROLLMENT_FEE);
        assertEquals(6666, AppConstants.ENROLLMENT_FEE_THRESHOLD);
        assertEquals(10000, AppConstants.G20_SUBTOTAL_THRESHOLD);
        assertEquals(2, AppConstants.G5_PROGRAMME_THRESHOLD);
    }
}
