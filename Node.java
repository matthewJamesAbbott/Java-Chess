package xyz.squig;

public class Node {
    int x;
    int y;
    int squareRank;
    Node next;

    public Node(int a, int b, int squareRank) {
        this.x = a;
        this.y = b;
        this.squareRank = squareRank;
        next = null;
    }
}
