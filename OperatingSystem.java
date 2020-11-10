package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OperatingSystem {

    public OperatingSystem(){

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

}
