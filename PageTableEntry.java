package com.company;

public class PageTableEntry {

    public boolean inMemory;

    /*
        Set inMemory to true by default.
     */
    public PageTableEntry(){
        inMemory = true;
    }

    /*
        Check if entry is in memory
     */
    protected boolean isInMemory(){
        return inMemory;
    }

    /*
        Kick entry from memory
     */
    protected void kickFromMemory(){
        inMemory = false;
    }

}