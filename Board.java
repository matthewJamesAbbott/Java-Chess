package xyz.squig;

public class Board {
    public Board() {
        String board[8][8];
    }

    String returnSquare(int x, int y){
        return board[x][y];
    }

    void setSquare(int x, int y, String piece){
        board[x][y] = piece;
    }

}
