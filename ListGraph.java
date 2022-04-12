package com.company;

import java.util.LinkedList;

public class ListGraph {
    LinkedList<String>[] edges;
    private int numV;
    private int numE;


    public ListGraph(int V) {
        this.numV = V;
        edges = (LinkedList<String>[]) new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<String>();
        }
    }

    public int getNumE() {
        return numE;
    }

    public int getNumV() {
        return numV;
    }

    public void addEdge(String name1, String name2) {
        int from = name1.hashCode()%numV;
        int to = name2.hashCode()%numV;
        if (from>= 0 && from < numV && to >= 0 && to < numV) {
            edges[from].add(name2);
            edges[to].add(name1);
            numE++;
        } else {
            System.out.println("Vertex out of bounds!");

        }
    }

    public void removeEdge(int from, int to) {
        if (edges[from].contains(to)) {
            edges[from].remove(to);
        } else {
            System.out.println("Edge not found!");
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < numV; i++) {
            sb.append(i+ " " + edges[i].toString() + "\n");
        }

        return sb.toString();
    }

    public boolean isAdjacent(int from, int to) {
        return edges[from].contains(to);
    }

    public LinkedList<Integer> neighborsList(int from) {
        return (LinkedList<Integer>) edges[from].clone();
    }

    public Integer[] neighborsArray(int from) {
        Integer[] ar = new Integer[edges[from].size()];
        edges[from].toArray(ar);
        return ar;
    }

    public int degree(int from) {
        return edges[from].size();
    }

    public static void main(String[] args) {
        ListGraph g = new ListGraph(5);

        g.addEdge("A" , "B");
        g.addEdge("A" , "C");
        g.addEdge("C" , "A");
        g.addEdge("C" , "D");
        g.addEdge("B" , "A");
        g.addEdge("B" , "D");
        g.addEdge("B" , "E");
        g.addEdge("D" , "C");
        g.addEdge("D" , "B");
        g.addEdge("D" , "E");
        System.out.println(g.toString());

    }
}
