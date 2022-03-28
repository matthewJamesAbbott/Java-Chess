package xyz.squig;

import java.util.Vector;
import java.util.Random;


public class Engine {
    Vector<Integer> returnVector = new Vector<Integer>();


    public void moveVector(TreeNode localRoot, int base){
        if (localRoot != null) {
            moveVector(localRoot.leftTreeNode, base);
            if (localRoot.rank == base) {
                returnVector.addElement(localRoot.x);
                returnVector.addElement(localRoot.y);
                returnVector.addElement(localRoot.xa);
                returnVector.addElement(localRoot.ya);
            }
            moveVector(localRoot.rightTreeNode, base);
        }
    }

    public int[] resolveMove(Board gameBoard){
        Tree moveTree = new Tree();
        MoveCalculator calc = new MoveCalculator();
        LinkedList list;
        Vector<Integer> moveVector;
        int base = 0;
        int MIN = 0;
        int MAX = 10;
        for(int e = 0; e < 8; e++){
            for(int i = 0; i < 8; i++){
                if(gameBoard.returnSquare(e,i).contains("White")){
                    list = calc.possibleSquares2DArray(e,i, gameBoard);
                    moveVector = list.returnWeightedVector();
                    for(int j = 0; j < moveVector.size()/3;) {
                        int a = moveVector.get(j);
                        int b = moveVector.get(j + 1);
                        int c = moveVector.get(j + 2);
                        if (c > base)
                            base = c;
                        if(c >= MIN && c <= MAX) {
                            moveTree.addTreeNode(c, e, i, a, b);
                        }
                        j = j + 3;
                    }
                }
            }
        }
        TreeNode stepper;
        stepper = moveTree.head;
        this.moveVector(stepper, base);
        int choice = 0;
        if(returnVector.size() >= 4){
            Random rand = new Random();
            int test = returnVector.size() / 4;
            choice = rand.nextInt(test);
            choice = choice * 4;
        }
        int[] move = new int[4];
        move[0] = returnVector.get(choice);
        move[1] = returnVector.get(choice + 1);
        move[2] = returnVector.get(choice + 2);
        move[3] = returnVector.get(choice + 3);
        return move;
    }
}
