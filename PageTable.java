package com.company;

import java.util.ArrayList;

public class PageTable {

    private final ArrayList<PageTableEntry> tableEntries;

    public PageTable(int maxEntries){
        // Instantiate Page Table
        tableEntries = new ArrayList<>();

        // Add 64 Entries To Page Table
        for(int i = 0; i < maxEntries; i++){
            tableEntries.add(null);
        }
    }

}