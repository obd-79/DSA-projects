package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner obd= new Scanner(System.in);
    static LoseLetter loseLetter = new LoseLetter();

    public static void main(String[] args) throws IOException {
        storePlayer();
        boolean flag = true;
        while (flag){
            System.out.println("chose an option :");printMenu();
            int number = obd.nextInt();
            switch (number){
                case 1 :
                    printName();
                    System.out.println("----------");
                    break;
                case 2 :
                    if (! Spin()){
                        flag = false;
                    }
                    System.out.println("---------");

                    break;

                case 3 :
                    flag = false;
            }
        }



    }
    public static void printMenu(){
        System.out.println("1-print the names");
        System.out.println("2-spin");
        System.out.println("3-quit");
    }
    public static void storePlayer( ) throws IOException {
        System.out.print("Enter the number of players: ");
        int n = obd.nextInt();
        System.out.println("Reading the names...");
        loseLetter.storeFile(n);
        System.out.println("------------");
        System.out.println("the chosen names are : ");
        loseLetter.printPlayers();
        System.out.println("-------------");
    }
    public static boolean Spin(){
        System.out.println("--------------");
        boolean o = loseLetter.deleteLetter();
        return o;
    }
    public static void printName(){
        loseLetter.printPlayers();
    }
}


