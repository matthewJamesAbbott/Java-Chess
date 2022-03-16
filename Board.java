package xyz.squig;

public class Board {
    public String[][] board = new String[8][8];
    public Board() {

    }

    String returnSquare(int x, int y){
        return board[x][y];
    }

    void setSquare(int x, int y, String piece){
        board[x][y] = piece;
    }

}
