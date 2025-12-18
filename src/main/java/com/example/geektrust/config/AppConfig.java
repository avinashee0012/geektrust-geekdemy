package com.example.geektrust.config;

import java.util.List;

import com.example.geektrust.command.CommandInvoker;

public class AppConfig {  
    private final CommandInvoker commandInvoker;
    private final InputReader inputReader;
    
    public AppConfig(CommandInvoker commandInvoker, InputReader inputReader){
        this.commandInvoker = commandInvoker;
        this.inputReader =inputReader;
    }

    public void process(String[] args){
        List<List<String>> commands = inputReader.read(args[0]);
        for (List<String> tokens : commands) {
            String commandName = tokens.get(0);
            commandInvoker.invoke(commandName, tokens);
        }
    }
}
