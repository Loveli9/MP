package com.hyp.collections.collectionStudy.map;

public class Node {

    private Object node;
    private Node next;

    public Node(Object node, Node next) {
        this.node = node;
        this.next = next;
    }

    public static void main(String[] args) {
        Node header = new Node(new Object(),null);
        Node newNode = new Node(new Object(),null);
        header.next = newNode;
        Node newNode2 = new Node(new Object(),header);
        header = newNode2;

    }


}
