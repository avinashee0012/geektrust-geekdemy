package com.example.geektrust;

import com.example.geektrust.config.AppConfig;

public class Main {
    public static void main(String[] args){
        AppConfig appConfig = new AppConfig();
        appConfig.setup();

        // args = new String[]{"sample_input/input1.txt"};

        appConfig.process(args); 
    }
}
