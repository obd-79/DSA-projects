package com.company;

public class DoubleNode2 {
    String name;
    String massage;
    boolean special;
    DoubleNode2 next;
    DoubleNode2 previous;

    public DoubleNode2(String name) {
        this.name = name;
        special = false;
        this.massage = "";
        this.previous = null;
        this.next = null;
    }
}
