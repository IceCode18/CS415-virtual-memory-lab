package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperatingSystem {

    ArrayList<PageTable> processTable;

    private int currentProcessIndex;
    private int access, miss, compulsoryMiss, hit;
    private final int MAX_ENTRIES = 64;
    private final int MAX_MEMORY_FRAMES = 30;

    public OperatingSystem(){
        currentProcessIndex = -1;
        access = 0;
        miss = 0;
        compulsoryMiss = 0;
        hit = 0;
        processTable = new ArrayList<>();
    }

    protected void start(){
        System.out.print("Enter text file: ");
        Scanner s = new Scanner(System.in);
        File text = new File(s.next());
        s.close();
        try {
            s = new Scanner(text);
            while (s.hasNext()){
                String[] line = s.nextLine().split(" ");
                String command = line[0];
                String value = line[1];
                System.out.println("command: "+command+", value: "+value);
            }
            s.close();

        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file!");
        }
    }

    private void newProcess(){
        PageTable t = new PageTable(MAX_ENTRIES);
        processTable.add(t);
    }


}
