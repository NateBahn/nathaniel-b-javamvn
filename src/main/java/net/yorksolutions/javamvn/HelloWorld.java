package net.yorksolutions.javamvn;

import java.sql.SQLOutput;

public class HelloWorld {
    public int count = 0;
    private int count1 = 0;
    int count2 = 0;
    protected int count3 = 0;

    // visibility - what is allowed to see this field (variable, method)
    //public - anything
    //private - only the class
    //package (default) - private plus any other class in the same package
    //protected - any class that extends this class



    public void myFirstMethod(){
        System.out.println("Count equals" + count);
    }



    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();

        hw.myFirstMethod();


        HelloWorld hw2 = new HelloWorld();






    }

}
