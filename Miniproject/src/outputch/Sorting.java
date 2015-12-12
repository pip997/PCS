package outputch;

import java.util.Random;

public class Sorting {
    int [] array = new int[100];
    int counter = 0;
    String name = "empty";
    
    public Sorting(){
    }
    
    public Sorting(String name){
        this.name = name;
    }
    
    public void getUserInput(){
        Random rg = new Random();
        for (int i=0; i< 100; i++)
            array[i] = rg.nextInt(1000);
    }
    
    public void increaseCounter(){
        counter++;
    }
    
    public void printArray(){
        System.out.println();
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    
    public void printComplexity(){
        System.out.println("\nComplexity of " + name 
                + ": " + "\nInput size: " 
                + array.length 
                + "\nNumber of executed commands: " 
                + counter);
        
    }
}
