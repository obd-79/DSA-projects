package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class Graph {
    private HashMap<Edge, LinkedList<Edge>> TheList;
    private boolean directed;
    private HashMap<String , Edge> Characters;

    public Graph(boolean directed) {
        this.directed = directed;
        TheList = new HashMap<>();
        Characters = new HashMap<>();
    }

    private void AddHelper(Edge a, Edge b) {
        LinkedList<Edge> tmp = TheList.get(a);

        if (tmp != null) {
            tmp.remove(b);
        } else tmp = new LinkedList<>();
        tmp.add(b);
        TheList.put(a, tmp);
    }
    public void AddCharacter(Edge source, Edge Target) {
// We make sure that every used node shows up in our .keySet()
        if (!TheList.keySet().contains(source))
            TheList.put(source, null);

        if (!TheList.keySet().contains(Target))
            TheList.put(Target, null);

        AddHelper(source, Target);

        // If a graph is undirected, we want to add an edge from destination to source as well
        if (!directed) {
            AddHelper(Target, source);
        }

    }

    public void printEdges() {
        for (Edge node : TheList.keySet()) {
            System.out.print("The " + node.source + " has an edge towards: ");
            if (TheList.get(node) != null) {
                for (Edge neighbor : TheList.get(node)) {
                    System.out.print(neighbor.source + " ");
                }
                System.out.println();
            } else {
                System.out.println("none");
            }
        }
    }
    public void print(){
        for (int i = 0 ; i < TheList.size() ; i ++){

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.AddCharacter(new Edge("A") , new Edge("B"));
        g.AddCharacter(new Edge("A") , new Edge("C"));
        g.AddCharacter(new Edge("C") , new Edge("A"));
        g.AddCharacter(new Edge("C") , new Edge("D"));
        g.AddCharacter(new Edge("B") , new Edge("A"));
        g.AddCharacter(new Edge("B") , new Edge("D"));
        g.AddCharacter(new Edge("B") , new Edge("E"));
        g.AddCharacter(new Edge("D") , new Edge("C"));
        g.AddCharacter(new Edge("D") , new Edge("B"));
        g.AddCharacter(new Edge("D") , new Edge("E"));
        g.printEdges();
    }

}