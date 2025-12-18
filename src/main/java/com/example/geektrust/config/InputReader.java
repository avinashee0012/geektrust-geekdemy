package com.example.geektrust.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    
    public List<List<String>> read(String filePath){
        List<List<String>> commands = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                commands.add(Arrays.asList(sc.nextLine().split(" ")));
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commands;
    }
}
