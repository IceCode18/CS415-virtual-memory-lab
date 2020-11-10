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



}

