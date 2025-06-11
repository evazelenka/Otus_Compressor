package ru.otus.huffmancompress;

public class Node {
    int value;
    int weight;
    Node o,l;

    public Node (int value, int weight){
        this.weight = weight;
        this.value = value;
    }

    public Node(Node o, Node l){
        this.o = o;
        this.l = l;
        this.weight = o.weight + l.weight;
        this.value = -1;
    }


}
