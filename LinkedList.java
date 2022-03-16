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

    public Vector<Integer> returnVector() {
        Node temp = head;
        Vector<Integer> moveVector = new Vector<Integer>();
        while (temp != null){
            moveVector.addElement(temp.x);
            moveVector.addElement(temp.y);
            temp = temp.next;
        }
        return moveVector;
    }

}
