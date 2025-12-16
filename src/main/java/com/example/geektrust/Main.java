package com.example.geektrust;

import com.example.geektrust.command.CommandInvoker;
import com.example.geektrust.config.AppConfig;

public class Main {
    public static void main(String[] args){
        CommandInvoker commandInvoker = new CommandInvoker();
        AppConfig appConfig = new AppConfig(commandInvoker);
        appConfig.setup();

        appConfig.process(args);   
    }
}
