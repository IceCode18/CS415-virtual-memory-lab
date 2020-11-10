package com.company;

import java.util.ArrayList;

public class Memory {

    private final ArrayList<PageTableEntry> memory;
    int maxFrames;
    int insertedFrames;

    /**
     * Memory class constructor
     * @param maxFrames max number of frames in the memory
     */
    public Memory(int maxFrames){
        memory = new ArrayList<>();
        this.maxFrames = maxFrames;
        insertedFrames = 0;
    }

    /**
     * Set a frame in memory using a specific entry
     * @param e PageTableEntry type object to set memory frame to
     */
    public void getFreeFrame(PageTableEntry e){
        if( insertedFrames < maxFrames){
            memory.add(e);
        }else{
            int newIndex = (insertedFrames % maxFrames); // mod algorithm to enable round-robin frame setting style
            memory.get(newIndex).kickFromMemory(); // update inMemory boolean variable to false
            memory.set(newIndex,e); // update memory frame with a page table entry
        }
        insertedFrames++;
    }

}

