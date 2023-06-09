package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperatingSystem {

    ArrayList<PageTable> processTable;
    Memory memory;

    private int currentProcessIndex;
    private int access, miss, compulsoryMiss, hit;
    private final int MAX_ENTRIES = 64;
    private final int MAX_MEMORY_FRAMES = 30;

    /**
     * OS class constructor
     */
    public OperatingSystem(){
        currentProcessIndex = -1;
        access = 0;
        miss = 0;
        compulsoryMiss = 0;
        hit = 0;
        processTable = new ArrayList<>();
        memory = new Memory(MAX_MEMORY_FRAMES);
    }

    /**
     * Kick-starts the OS and performs commands from an input file.
     */
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
                switch (command) {
                    case "new" -> newProcess();
                    case "switch" -> {
                        int index = Integer.parseInt(value);
                        switchProcess(index);
                    }
                    case "access" -> {
                        int index = Integer.parseInt(value) >> 10;
                        accessTableEntry(index);
                    }
                    default -> System.out.println("Command not found: " + command);
                }
            }
            s.close();
            System.out.println("Access: "+ access);
            System.out.println("Hits: "+ hit);
            System.out.println("Misses: "+ miss);
            System.out.println("Compulsory Misses: "+ compulsoryMiss);
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file!");
        }
    }

    /**
     * Creates a page table along with a new process
     */
    private void newProcess(){
        PageTable t = new PageTable(MAX_ENTRIES);
        processTable.add(t);
    }

    /**
     * Switch active process
     * @param index - index of process to switch to
     */
    private void switchProcess(int index){
        currentProcessIndex = index-1;
    }

    /**
     * Access specific entry in a page table
     * @param entryIndex index of entry to access
     */
    private void accessTableEntry(int entryIndex){
        PageTable t = processTable.get(currentProcessIndex);
        PageTableEntry e = t.getTableEntry(entryIndex);
        if (e != null ){
            if(e.isInMemory()) {
                hit++;
            }else{
                miss++;
                updateEntry(t ,entryIndex);
            }
        }else{
            miss++;
            compulsoryMiss++;
            updateEntry(t, entryIndex);
        }
        access++;
    }

    /**
     * Call getFreeFrame method in Memory class and update it with a new PageTableEntry object
     * @param table PageTable object whose table entry needs updating
     * @param entryIndex index of the page table entry to update
     */
    private void updateEntry(PageTable table, int entryIndex){
        PageTableEntry newEntry = new PageTableEntry();
        memory.getFreeFrame(newEntry);
        table.updateTableEntry(entryIndex, newEntry);
    }
}
