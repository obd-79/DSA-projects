package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Q2 {
    static StudentMassage studentMassage = new StudentMassage();
    static Scanner obd= new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        studentMassage.storeFile();
        System.out.println("the players in the game are :");
        studentMassage.printPlayers();
        System.out.println("----------------------------");
        System.out.println("------we are starting the game--------");
        boolean flag = true;
        ChooseHub();
        System.out.println("---------");


        while (flag){
            System.out.println("chose an option :");printMenu();
            int num = obd.nextInt();
            switch (num){
                case 1 :
                    MoveMassage();
                    break;
                case 2:
                    printTheHubs();
                    break;
                case 3 :
                    printThePlayers();
                    break;
                case 4 :
                    flag = false;
            }
        }


    }
    public static void printMenu(){
        System.out.println("1-Move massage \n2-Print the hubs Students \n3-Print the chosen the students\n4-Quit the Game");

    }
    public static void ChooseHub (){
        System.out.println("Enter the number of Hubs");
        int num = obd.nextInt();
        studentMassage.choseHub(num);
        System.out.println("the Student hub have been chosen");
    }
    public static void MoveMassage(){
        System.out.println("Enter The source Student: ");
        String name = obd.next();
        System.out.println("Enter the Massage :");
        String massage = obd.next();
        System.out.println("Enter the number of students to pass the message : ");
        int number = obd.nextInt();
        studentMassage.moveMassage(name ,massage , number );
    }
    public static void printTheHubs(){
        studentMassage.printHub();
    }
    public static void printThePlayers(){
        studentMassage.printPlayers();
    }


}
