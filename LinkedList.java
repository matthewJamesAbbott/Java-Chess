package xyz.squig;

import java.util.*;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void addNode(int x, int y) {
        Node newNode = new Node(x, y);
        newNode.next = head;
        head = newNode;
    }

    public void returnVector() {
        Node temp = head;
        Vector<String> moveVector = new Vector<String>();
        while (temp != null){
            moveVector.addElement(x);
            moveVector.addElement(y);
            temp = temp.next;
        }
        return moveVector;
    }

}
