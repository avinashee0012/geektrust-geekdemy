package com.example.geektrust.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    void firstCommandForSample1ShouldBeAddProMembership(){
        String filePath = "sample_input/input1.txt";
        assertEquals("ADD_PRO_MEMBERSHIP", new InputReader().read(filePath).get(0).get(0));
    }
}
