package com.example.geektrust.model.enums;

public enum ProgrammeType {
    CERTIFICATION(3000, 2),
    DEGREE(5000, 3),
    DIPLOMA(2500, 1);

    private final int price;
    private final int proDiscount;

    private ProgrammeType(int price, int proDiscount) {
        this.price = price;
        this.proDiscount = proDiscount;
    }

    public int getPrice(){
        return price;
    }

    public int getProDiscount(){
        return proDiscount;
    }
}
