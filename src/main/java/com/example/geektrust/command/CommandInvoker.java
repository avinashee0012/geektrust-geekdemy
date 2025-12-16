package com.example.geektrust.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, ICommand> commandMap;

    public CommandInvoker() {
        this.commandMap = new HashMap<>();
    }

    public void register(String commandName, ICommand command){
        commandMap.put(commandName, command);
    }
    
    public void invoke(String commandName, List<String> tokens){
        if(commandMap.containsKey(commandName)){
            commandMap.get(commandName).execute(tokens);
        } else {
            throw new IllegalArgumentException("Invalid Command");
        }
    }
}
