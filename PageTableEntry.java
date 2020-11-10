package com.company;

public class PageTableEntry {

    public boolean inMemory;

    public PageTableEntry(){
        inMemory = true;
    }

    protected boolean isInMemory(){
        return inMemory;
    }

    protected void kickFromMemory(){
        inMemory = false;
    }

}