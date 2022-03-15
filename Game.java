package xyz.squig;

public class Game {


    pubic Game() {
        Board gameBoard = new Board();
    }


    public void setPlayerOne(String name){
        playerOne = name;
    }

    public void setPlayerTwo(String name){
        playerTwo = name;
    }

    public void initialiseBoard(){

        gameBoard.setSquare(0,0,"White Left Rook");
        gameBoard.setSquare(0,1,"White Left Knight");
        gameBoard.setSquare(0,2,"White Left Bishop");
        gameBoard.setSquare(0,3,"White Queen");
        gameBoard.setSquare(0,4,"White King");
        gameBoard.setSquare(0,5,"White Right Bishop");
        gameBoard.setSquare(0,6,"White Right Knight");
        gameBoard.setSquare(0,7,"White Right Rook");

        for(int i = 0; i < 8; i++){
            gameBoard.setSquare(1,i,"White Pawn");
        }

        for(int e = 2; e < 6; e++){
            for(int i = 0; i < 8; i++){
                gameBoard.setSquare(e,i,"Empty");
            }
        }

        for(int i = 0; i < 8; i++){
            gameBoard.setSquare(6,i,"Black Pawn");
        }

        gameBoard.setSquare(7,0,"Black Left Rook");
        gameBoard.setSquare(7,1,"Black Left Knight");
        gameBoard.setSquare(7,2,"Black Left Bishop");
        gameBoard.setSquare(7,3,"Black Queen");
        gameBoard.setSquare(7,4,"Black King");
        gameBoard.setSquare(7,5,"Black Right Bishop");
        gameBoard.setSquare(7,6,"Black Right Knight");
        gameBoard.setSquare(7,7,"Black Right Rook");
    }

    public void printBoardToTerminal() {

        int a = 1;
        int b = 3;
        int c = 5;
        int d = 7;
        String piece = "";
        for(int e = 0; e < 9; e++) {
            for (int i = 0; i < 9; i++) {
                if (e > 0 && i > 0) {
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White Left Rook" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "White Right Rook")
                        piece = "\e[97m\u265C";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White Left Knight" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "White Right Knight")
                        piece = "\e[97m\u265E";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White Left Bishop" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "White Right Bishop")
                        piece = "\e[97m\u265D";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White King")
                        piece = "\e[97m\u265A";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White Queen")
                        piece = "\e[97m\u265B";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "White Pawn")
                        piece = "\e[97m\u265F";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black Left Rook" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "Black Right Rook")
                        piece = "\e[30m\u265C";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black Left Knight" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "Black Right Knight")
                        piece = "\e[30m\u265E";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black Left Bishop" ||
                            gameBoard.returnSquare(e - 1, i - 1) == "Black Right Bishop")
                        piece = "\e[30m\u265D";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black King")
                        piece = "\e[30m\u265A";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black Queen")
                        piece = "\e[30m\u265B";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Black Pawn")
                        piece = "\e[30m\u265F";
                    if (gameBoard.returnSquare(e - 1, i - 1) == "Empty")
                        piece = " ";
                    if (i == a || i == b || i == c || i == d)
                        System.out.print("\e[44m " + piece + " ");
                    else
                        System.out.print("\e[101m " + piece + " ");
                }
                if(i == 0){

                    if(e == 0)
                        System.out.print("\e[49m   \e[49m\e[39m");
                    if(e == 1)
                        System.out.print("\e[43m \e[30m8 \e[49m\e[39m");
                    if(e == 2)
                        System.out.print("\e[49m \e[33m7 \e[49m\e[39m");
                    if(e == 3)
                        System.out.print("\e[43m \e[30m6 \e[49m\e[39m");
                    if(e == 4)
                        System.out.print("\e[49m \e[33m5 \e[49m\e[39m");
                    if(e == 5)
                        System.out.print("\e[43m \e[30m4 \e[49m\e[39m");
                    if(e == 6)
                        System.out.print("\e[49m \e[33m3 \e[49m\e[39m");
                    if(e == 7)
                        System.out.print("\e[43m \e[30m2 \e[49m\e[39m");
                    if(e == 8)
                        System.out.print("\e[49m\e[33m 1 \e[49m\e[39m");
                }
            }

            System.out.println("\e[49m\e[39m");

            if (e == 1) {
                a++;
                b++;
                c++;
                d++;
            } else if (e == 2) {
                a--;
                b--;
                c--;
                d--;
            } else if (e == 3) {
                a++;
                b++;
                c++;
                d++;
            } else if (e == 4) {
                a--;
                b--;
                c--;
                d--;
            } else if (e == 5) {
                a++;
                b++;
                c++;
                d++;
            } else if (e == 6) {
                a--;
                b--;
                c--;
                d--;
            } else if (e == 7) {
                a++;
                b++;
                c++;
                d++;
            }
        }
        System.out.println("\e[43m   " + "\e[49m \e[33mA " + "\e[43m \e[30mB " + "\e[49m \e[33mC " + "\e[43m \e[30mD " + "\e[49m \e[33mE " + "\e[43m \e[30mF " + "\e[49m \e[33mG " + "\e[43m \e[30mH " + "\e[49m\e[39m");
    }

    public bool movePiece(int ia, char ca, int ib, char cb) {
        int ya;
        if(ca == 'A' || ca == 'a')
            ya = 0;
        else if(ca == 'B' || ca == 'b')
            ya = 1;
        else if(ca == 'C' || ca == 'c')
            ya = 2;
        else if(ca == 'D' || ca == 'd')
            ya = 3;
        else if(ca == 'E' || ca == 'e')
            ya = 4;
        else if(ca == 'F' || ca == 'f')
            ya = 5;
        else if(ca == 'G' || ca == 'g')
            ya = 6;
        else if(ca == 'H' || ca == 'h')
            ya = 7;
        int xa;

        if(ia == 1)
            xa = 7;
        else if(ia == 2)
            xa = 6;
        else if(ia == 3)
            xa = 5;
        else if(ia == 4)
            xa = 4;
        else if(ia == 5)
            xa = 3;
        else if(ia == 6)
            xa = 2;
        else if(ia == 7)
            xa = 1;
        else if(ia == 8)
            xa = 0;
        int yb;
        if(cb == 'A' || cb == 'a')
            yb = 0;
        else if(cb == 'B' || cb == 'b')
            yb = 1;
        else if(cb == 'C' || cb == 'c')
            yb = 2;
        else if(cb == 'D' || cb == 'd')
            yb = 3;
        else if(cb == 'E' || cb == 'e')
            yb = 4;
        else if(cb == 'F' || cb == 'f')
            yb = 5;
        else if(cb == 'G' || cb == 'g')
            yb = 6;
        else if(cb == 'H' || cb == 'h')
            yb = 7;
        int xb;
        if(ib == 1)
            xb = 7;
        else if(ib == 2)
            xb = 6;
        else if(ib == 3)
            xb = 5;
        else if(ib == 4)
            xb = 4;
        else if(ib == 5)
            xb = 3;
        else if(ib == 6)
            xb = 2;
        else if(ib == 7)
            xb = 1;
        else if(ib == 8)
            xb = 0;



        MoveCalculator calc;
        LinkedList list;
        list = calc.possibleSquares2DArray(xa, ya, gameBoard);
        Vector<int> moveVector;
        moveVector = list.returnVector();
        for(int i = 0; i < moveVector.size();) {
            int a = moveVector[i];
            int b = moveVector[i + 1];
            System.out.println(a + " " << b + " ");
            System.out.println(xb + " " + yb + " ");
            System.out.println(xa + " " + ya + " ");
            i = i + 2;
            if (xb == a && yb == b) {
                String originalSquare = gameBoard.returnSquare(xa, ya);
                gameBoard.setSquare(xb, yb, originalSquare);
                gameBoard.setSquare(xa, ya, "Empty");

                return true;
            }
        }
        return false;
    }
}