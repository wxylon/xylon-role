package test;

import java.io.*;
public class Quiz1{
    public static void main(String arg[]){
        int i;
        System.out.print("Go ");
        try{
            System.out.print("in ");
            i=System.in.read();
            if (i=='0') {throw new Exception();}
            System.out.print("this ");
        }
        catch(IOException e){}
        catch(Exception e){
            System.out.print("that ");
        }
        System.out.print("way.\n");
    }
}
