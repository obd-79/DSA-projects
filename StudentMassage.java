package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class StudentMassage {
    DoubleNode2 first, last;
    int size;

    public StudentMassage() {

    }
    public void storeFile() throws IOException {
        File f=new File("class.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int c = 0;
        String name = "";
        StudentMassage doubleLinkedList = new StudentMassage();
        while((c = br.read()) != -1)
        {
            char character = (char) c;
            name = name + character;
            if (name.contains(" ") ){
                doubleLinkedList.add(name);
                br.readLine();
                name = "";
            }
        }
        ArrayList<Integer> list = getRandomNonRepeatingIntegers(30, 0, doubleLinkedList.size);
        for (int i = 0 ; i < list.size() ; i ++) {
            DoubleNode2 temp = doubleLinkedList.first;
            for (int j = 0; j < list.get(i); j++) {

                temp = temp.next;
            }
            add(temp.name);


        }



    }




    public void add(String name) {
        DoubleNode2 newValue = new DoubleNode2(name);
        if (isEmpty()) {
            first = newValue;
            last = newValue;
        } else {
            last.next = newValue;
            newValue.previous = last;
            last = newValue;
            size++;

        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void printPlayers() {
        DoubleNode2 temp = first;
        for (int i = 0; i <= size; i++) {
            System.out.println((i+1) + "-"+temp.name);
            temp = temp.next;
        }
    }

    public DoubleNode2 Search(String name){
        DoubleNode2 temp  = first;
        while (temp!= null){
            if (temp.name.equals(name+" " )|| temp.name.equals(name+" *")){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    private   int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    private ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,
                                                             int max) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        while (numbers.size() < size) {
            int random = getRandomInt(min, max);

            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }

        return numbers;
    }



    public void choseHub(int number ){

        ArrayList<Integer> list = getRandomNonRepeatingIntegers(number, 0, 30);
        for (Integer integer : list) {
            DoubleNode2 temp = first;
            for (int j = 0; j < integer; j++) {

                temp = temp.next;
            }
            temp.special = true;
            temp.name = temp.name + "*";

        }



    }
    public void printHub(){
        DoubleNode2 temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.special) {
                System.out.println(temp.name);
            }
            temp = temp.next;
        }

    }

    public void moveMassage(String name, String massage, int kth) {
        DoubleNode2 source = Search(name);
        int copy = kth;
        int random = chooseDirection();
        while ( copy > 0){
              if (source.name.equals(first.name) ){
                System.out.println("this is the first Student and we cant go back");
                copy = 0;
            }
              else if (source.previous == null){
                System.out.println("we reached to the first Student and we cant go back");
                copy=0;

            }

           else if (random == 0 ) {
                source = source.previous;
                if (source.special){
                    copy = kth+1;
                    System.out.println("it arrived to hub " + source.name);
                }

                copy--;

            }

                 if (source.name.equals(last.name)){
                      System.out.println("this is the last student and we cant go forward");
                      copy = 0;
                  }
                 else if (source.next == null){
                    System.out.println("we reached to the last Student and we cant go forward");
                    copy=0;
                }
                 else {

                source = source.next;
                if (source.special){
                    copy = kth+1;
                    System.out.println("it arrived to hub " + source.name);
                }
                copy--;

            }
            System.out.println("we are now in " + source.name);





        }

        source.massage = massage;
        System.out.println("the massage now with " + source.name);
    }
    public int chooseDirection(){
        int random = getRandomInt(0,2);
        if (random == 0){
            System.out.println("we are going back ");
        }
        else {
            System.out.println("we are going forward");
        }
        return random;

    }

}
