package com.company;

import java.util.ArrayList;

public class PageTable {

    private final ArrayList<PageTableEntry> tableEntries;

    /**
     * PageTable Constructor
     * @param maxEntries maximum number of entries in a page table
     */
    public PageTable(int maxEntries){
        // Instantiate Page Table
        tableEntries = new ArrayList<>();

        // Add 64 Entries To Page Table
        for(int i = 0; i < maxEntries; i++){
            tableEntries.add(null);
        }
    }

    /**
     * Returns specific page table entry
     * @param entryIndex index of the table entry
     * @return table entry
     */
    protected PageTableEntry getTableEntry(int entryIndex){
        return tableEntries.get(entryIndex);
    }

    /**
     * Updates specific page table entry
     * @param entryIndex index of the table entry
     * @param e PageTableEntry type object to update the table entry with
     */
    protected void updateTableEntry(int entryIndex, PageTableEntry e){
        tableEntries.set(entryIndex, e);
    }

}