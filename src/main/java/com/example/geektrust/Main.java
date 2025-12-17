package com.example.geektrust;

import com.example.geektrust.command.CommandInvoker;
import com.example.geektrust.config.AppConfig;

public class Main {
    public static void main(String[] args){
        CommandInvoker commandInvoker = new CommandInvoker();
        AppConfig appConfig = new AppConfig(commandInvoker);
        appConfig.setup();

        // args = new String[]{"sample_input/input1.txt"};

        appConfig.process(args); 
    }
}
