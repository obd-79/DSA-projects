package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LoseLetter {
    private DoubleNode first;
    private int size;
    CircleLinkedList namesOnly = new CircleLinkedList();
    public LoseLetter() {
        this.first = null;
        size = 0;
    }
    public void insert(String name){
        DoubleNode newNode = new DoubleNode(name);
        if (first == null){
            newNode.next = newNode;
            newNode.previous = newNode;
            first = newNode;
        }
        else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous.next = newNode;
            first.previous = newNode;
        }
        size ++;
    }

    public boolean deleteLetter() {
        DoubleNode temp2 = namesOnly.first;
        DoubleNode temp = first;
        if (size > 1) {
            int Kth = getRandomInt(0, size - 1);
            System.out.println("Generate random number.....");
            System.out.println("the kth number is " + (Kth + 1));
            while (Kth > 0) {
                temp = temp.next;
                temp2 = temp2.next;
                Kth--;
            }
            System.out.println("the chosen name is " + temp2.name);
            int letter = temp.name.length();
            System.out.println("deleting letter....");

            if (letter > 1) {
                temp.name = temp.name.substring(0, temp.name.length() - 1);
                System.out.println("the name now " + temp.name);
            } else {
                System.out.println("the name has only one letter which is " + temp.name);
                temp.previous.next = temp.next;
                temp.next.previous = first.previous;
                temp2.previous.next = temp2.next;
                temp2.next.previous = first.previous;
                System.out.println("the name is deleted");
                size--;
            }
            return true;
        }
        else
            System.out.println("the winner is " +temp2.name);
        return false;
        }


    public void printPlayers(){
        DoubleNode temp = first;
        for (int i = 0 ; i < size ; i++){
            System.out.println((i+1) +"-"+temp.name);
            temp = temp.next;
        }
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
    public void storeFile(int n) throws IOException {
        File f=new File("class.txt");
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        int c = 0;
        String name = "";
        LoseLetter LoserLetter = new LoseLetter();
        while((c = br.read()) != -1)
        {
            char character = (char) c;
            name = name + character;
            if (name.contains(" ") ){
                while (name.endsWith(" ")) {
                    name = name.substring(0, name.length() - 1);
                }
                LoserLetter.insert(name);
                br.readLine();
                name = "";
            }
        }
        ArrayList<Integer> list = getRandomNonRepeatingIntegers(n, 0, LoserLetter.size);
        for (Integer integer : list) {
            DoubleNode temp = LoserLetter.first;
            for (int j = 0; j < integer; j++) {
                temp = temp.next;
            }
            insert(temp.name);
            namesOnly.insert(temp.name);
        }
    }
}
 class CircleLinkedList { // We made this because we were losing the names in the game so we this fixed Circle LinkedList
     DoubleNode first;
     int size;

    public CircleLinkedList() {
        this.first = null;
        size = 0;
    }

    public void insert(String name) {
        DoubleNode newNode = new DoubleNode(name);
        if (first == null) {
            newNode.next = newNode;
            newNode.previous = newNode;
            first = newNode;
        } else {
            newNode.next = first;
            newNode.previous = first.previous;
            first.previous.next = newNode;
            first.previous = newNode;
        }
        size++;
    }
}
