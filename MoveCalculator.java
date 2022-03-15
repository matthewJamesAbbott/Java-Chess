public class MoveCalculator {
    MoveCalculator() {
    }


    LinkedList possibleSquares2DArray(int x, int y, Board moveBoard) {

        String piece = moveBoard.returnSquare(x, y);

        int switchedPiece = 0;

        if (piece == "White Left Rook")
            switchedPiece = 1;
        if (piece == "White Left Knight")
            switchedPiece = 2;
        if (piece == "White Left Bishop")
            switchedPiece = 3;
        if (piece == "White Queen")
            switchedPiece = 4;
        if (piece == "White King")
            switchedPiece = 5;
        if (piece == "White Right Bishop")
            switchedPiece = 6;
        if (piece == "White Right Knight")
            switchedPiece = 7;
        if (piece == "White Right Rook")
            switchedPiece = 8;
        if (piece == "White Pawn")
            switchedPiece = 9;
        if (piece == "Black Left Rook")
            switchedPiece = 10;
        if (piece == "Black Left Knight")
            switchedPiece = 11;
        if (piece == "Black Left Bishop")
            switchedPiece = 12;
        if (piece == "Black Queen")
            switchedPiece = 13;
        if (piece == "Black King")
            switchedPiece = 14;
        if (piece == "Black Right Bishop")
            switchedPiece = 15;
        if (piece == "Black Right Knight")
            switchedPiece = 16;
        if (piece == "Black Right Rook")
            switchedPiece = 17;
        if (piece == "Black Pawn")
            switchedPiece = 18;
        if (piece == "Empty")
            switchedPiece = 19;

        LinkedList list = new LinkedList();

        switch (switchedPiece) {
            case 1: // White Left Rook Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                return list;

            case 2: // White Left Knight Moves
                if (x < 6 && y < 7 && moveBoard.returnSquare(x + 2, y + 1) == "Empty")
                    list.addNode(x + 2, y + 1);
                else if (x < 6 && y < 7 && (!moveBoard.returnSquare(x + 2, y + 1).contains("Black")))
                    list.addNode(x + 2, y + 1);
                if (x < 6 && y > 0 && moveBoard.returnSquare(x + 2, y - 1) == "Empty")
                    list.addNode(x + 2, y - 1);
                else if (x < 6 && y > 0 && (!moveBoard.returnSquare(x + 2, y - 1).contains("Black")))
                    list.addNode(x + 2, y - 1);
                if (x < 7 && y < 6 && moveBoard.returnSquare(x + 1, y + 2) == "Empty")
                    list.addNode(x + 1, y + 2);
                else if (x < 7 && y < 6 && (!moveBoard.returnSquare(x + 1, y + 2).contains("Black")))
                    list.addNode(x + 1, y + 2);
                if (x < 7 && y > 1 && moveBoard.returnSquare(x + 1, y - 2) == "Empty")
                    list.addNode(x + 1, y - 2);
                else if (x < 7 && y > 1 && (!moveBoard.returnSquare(x + 1, y - 2).contains("Black")))
                    list.addNode(x + 1, y - 2);
                if (x > 1 && y < 7 && moveBoard.returnSquare(x - 2, y + 1) == "Empty")
                    list.addNode(x - 2, y + 1);
                else if (x > 1 && y < 7 && (!moveBoard.returnSquare(x - 2, y + 1).contains("Black")))
                    list.addNode(x - 2, y + 1);
                if (x > 1 && y < 0 && moveBoard.returnSquare(x - 2, y - 1) == "Empty")
                    list.addNode(x - 2, y - 1);
                else if (x > 1 && y > 0 && (!moveBoard.returnSquare(x - 2, y - 1).contains("Black")))
                    list.addNode(x - 2, y - 1);
                if (x > 0 && y < 6 && moveBoard.returnSquare(x - 1, y + 2) == "Empty")
                    list.addNode(x - 1, y + 2);
                else if (x > 0 && y < 6 && (!moveBoard.returnSquare(x - 1, y + 2).contains("Black")))
                    list.addNode(x - 1, y + 2);
                if (x > 0 && y > 1 && moveBoard.returnSquare(x - 1, y - 2) == "Empty")
                    list.addNode(x - 1, y - 2);
                else if (x > 0 && y > 1 && (!moveBoard.returnSquare(x - 1, y - 2).contains("Black")))
                    list.addNode(x - 1, y - 2);
                return list;

            case 3: // White Left Bishop Moves
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 4: // White Queen Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i >= 0 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e >= 0 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e > 0 && i > 0 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 5: // White King Moves
                if (x < 8 && moveBoard.returnSquare(x + 1, y) == "Empty")
                    list.addNode(x + 1, y);
                else if (x < 8 && (!moveBoard.returnSquare(x + 1, y).contains("Black")))
                    list.addNode(x + 1, y);
                if (x > 0 && moveBoard.returnSquare(x - 1, y) == "Empty")
                    list.addNode(x - 1, y);
                else if (x > 0 && (!moveBoard.returnSquare(x - 1, y).contains("Black")))
                    list.addNode(x - 1, y);
                if (y < 8 && moveBoard.returnSquare(x, y + 1) == "Empty")
                    list.addNode(x, y + 1);
                else if (y < 8 && (!moveBoard.returnSquare(x, y + 1).contains("Black")))
                    list.addNode(x, y + 1);
                if (y > 0 && moveBoard.returnSquare(x, y - 1) == "Empty")
                    list.addNode(x, y - 1);
                else if (y > 0 && (!moveBoard.returnSquare(x, y - 1).contains("Black")))
                    list.addNode(x, y - 1);
                if (x < 8 && y < 8 && moveBoard.returnSquare(x + 1, y + 1) == "Empty")
                    list.addNode(x + 1, y + 1);
                else if (x < 8 && y < 8 && (!moveBoard.returnSquare(x + 1, y + 1).contains("Black")))
                    list.addNode(x + 1, y + 1);
                if (x < 8 && y > 0 && moveBoard.returnSquare(x + 1, y - 1) == "Empty")
                    list.addNode(x + 1, y - 1);
                else if (x < 8 && y > 0 && (!moveBoard.returnSquare(x + 1, y - 1).contains("Black")))
                    list.addNode(x + 1, y - 1);
                if (x > 0 && y < 8 && moveBoard.returnSquare(x - 1, y + 1) == "Empty")
                    list.addNode(x - 1, y + 1);
                else if (x > 0 && y < 8 && (!moveBoard.returnSquare(x - 1, y + 1).contains("Black")))
                    list.addNode(x - 1, y + 1);
                if (x > 0 && y > 0 && moveBoard.returnSquare(x - 1, y - 1) == "Empty")
                    list.addNode(x - 1, y - 1);
                else if (x > 0 && y > 0 && (!moveBoard.returnSquare(x - 1, y - 1).contains("Black")))
                    list.addNode(x - 1, y - 1);
                return list;

            case 6: // White Right Bishop Moves
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("Black"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 7: // White Right Knight Moves
                if (x < 6 && y < 7 && moveBoard.returnSquare(x + 2, y + 1) == "Empty")
                    list.addNode(x + 2, y + 1);
                else if (x < 6 && y < 7 && (!moveBoard.returnSquare(x + 2, y + 1).contains("Black")))
                    list.addNode(x + 2, y + 1);
                if (x < 6 && y > 0 && moveBoard.returnSquare(x + 2, y - 1) == "Empty")
                    list.addNode(x + 2, y - 1);
                else if (x < 6 && y > 0 && (!moveBoard.returnSquare(x + 2, y - 1).contains("Black")))
                    list.addNode(x + 2, y - 1);
                if (x < 7 && y < 6 && moveBoard.returnSquare(x + 1, y + 2) == "Empty")
                    list.addNode(x + 1, y + 2);
                else if (x < 7 && y < 6 && (!moveBoard.returnSquare(x + 1, y + 2).contains("Black")))
                    list.addNode(x + 1, y + 2);
                if (x < 7 && y > 1 && moveBoard.returnSquare(x + 1, y - 2) == "Empty")
                    list.addNode(x + 1, y - 2);
                else if (x < 7 && y > 1 && (!moveBoard.returnSquare(x + 1, y - 2).contains("Black")))
                    list.addNode(x + 1, y - 2);
                if (x > 1 && y < 7 && moveBoard.returnSquare(x - 2, y + 1) == "Empty")
                    list.addNode(x - 2, y + 1);
                else if (x > 1 && y < 7 && (!moveBoard.returnSquare(x - 2, y + 1).contains("Black")))
                    list.addNode(x - 2, y + 1);
                if (x > 1 && y < 0 && moveBoard.returnSquare(x - 2, y - 1) == "Empty")
                    list.addNode(x - 2, y - 1);
                else if (x > 1 && y > 0 && (!moveBoard.returnSquare(x - 2, y - 1).contains("Black")))
                    list.addNode(x - 2, y - 1);
                if (x > 0 && y < 6 && moveBoard.returnSquare(x - 1, y + 2) == "Empty")
                    list.addNode(x - 1, y + 2);
                else if (x > 0 && y < 6 && (!moveBoard.returnSquare(x - 1, y + 2).contains("Black")))
                    list.addNode(x - 1, y + 2);
                if (x > 0 && y > 1 && moveBoard.returnSquare(x - 1, y - 2) == "Empty")
                    list.addNode(x - 1, y - 2);
                else if (x > 0 && y > 1 && (!moveBoard.returnSquare(x - 1, y - 2).contains("Black")))
                    list.addNode(x - 1, y - 2);
                return list;


            case 8: // White Right Rook Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("Black"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("Black"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                return list;

            case 9: // White Pawn Moves
                if (x != 7 && moveBoard.returnSquare(x + 1, y) == "Empty")
                    list.addNode(x + 1, y);
                if (x == 1 && moveBoard.returnSquare(x + 1, y) == "Empty" && moveBoard.returnSquare(x + 2, y) == "Empty")
                    list.addNode(x + 2, y);
                if (x != 7 && y != 7 && (!moveBoard.returnSquare(x + 1, y + 1).contains("Black")))
                    list.addNode(x + 1, y + 1);
                if (x != 7 && y != 0 && (!moveBoard.returnSquare(x + 1, y - 1).contains("Black")))
                    list.addNode(x + 1, y - 1);
                return list;

            case 10: // Black Left Rook Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                return list;

            case 11: // Black Left Knight Moves
                if (x < 6 && y < 7 && moveBoard.returnSquare(x + 2, y + 1) == "Empty")
                    list.addNode(x + 2, y + 1);
                else if (x < 6 && y < 7 && (!moveBoard.returnSquare(x + 2, y + 1).contains("White")))
                    list.addNode(x + 2, y + 1);
                if (x < 6 && y > 0 && moveBoard.returnSquare(x + 2, y - 1) == "Empty")
                    list.addNode(x + 2, y - 1);
                else if (x < 6 && y > 0 && (!moveBoard.returnSquare(x + 2, y - 1).contains("White")))
                    list.addNode(x + 2, y - 1);
                if (x < 7 && y < 6 && moveBoard.returnSquare(x + 1, y + 2) == "Empty")
                    list.addNode(x + 1, y + 2);
                else if (x < 7 && y < 6 && (!moveBoard.returnSquare(x + 1, y + 2).contains("White")))
                    list.addNode(x + 1, y + 2);
                if (x < 7 && y > 1 && moveBoard.returnSquare(x + 1, y - 2) == "Empty")
                    list.addNode(x + 1, y - 2);
                else if (x < 7 && y > 1 && (!moveBoard.returnSquare(x + 1, y - 2).contains("White")))
                    list.addNode(x + 1, y - 2);
                if (x > 1 && y < 7 && moveBoard.returnSquare(x - 2, y + 1) == "Empty")
                    list.addNode(x - 2, y + 1);
                else if (x > 1 && y < 7 && (!moveBoard.returnSquare(x - 2, y + 1).contains("White")))
                    list.addNode(x - 2, y + 1);
                if (x > 1 && y < 0 && moveBoard.returnSquare(x - 2, y - 1) == "Empty")
                    list.addNode(x - 2, y - 1);
                else if (x > 1 && y > 0 && (!moveBoard.returnSquare(x - 2, y - 1).contains("White")))
                    list.addNode(x - 2, y - 1);
                if (x > 0 && y < 6 && moveBoard.returnSquare(x - 1, y + 2) == "Empty")
                    list.addNode(x - 1, y + 2);
                else if (x > 0 && y < 6 && (!moveBoard.returnSquare(x - 1, y + 2).contains("White")))
                    list.addNode(x - 1, y + 2);
                if (x > 0 && y > 1 && moveBoard.returnSquare(x - 1, y - 2) == "Empty")
                    list.addNode(x - 1, y - 2);
                else if (x > 0 && y > 1 && (!moveBoard.returnSquare(x - 1, y - 2).contains("White")))
                    list.addNode(x - 1, y - 2);
                return list;

            case 12: // Black Left Bishop Moves
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 13: // Black Queen Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i >= 0 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e >= 0 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e > 0 && i > 0 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 14: // Black King Moves
                if (x < 8 && moveBoard.returnSquare(x + 1, y) == "Empty")
                    list.addNode(x + 1, y);
                else if (x < 8 && (!moveBoard.returnSquare(x + 1, y).contains("White")))
                    list.addNode(x + 1, y);
                if (x > 0 && moveBoard.returnSquare(x - 1, y) == "Empty")
                    list.addNode(x - 1, y);
                else if (x > 0 && (!moveBoard.returnSquare(x - 1, y).contains("White")))
                    list.addNode(x - 1, y);
                if (y < 8 && moveBoard.returnSquare(x, y + 1) == "Empty")
                    list.addNode(x, y + 1);
                else if (y < 8 && (!moveBoard.returnSquare(x, y + 1).contains("White")))
                    list.addNode(x, y + 1);
                if (y > 0 && moveBoard.returnSquare(x, y - 1) == "Empty")
                    list.addNode(x, y - 1);
                else if (y > 0 && (!moveBoard.returnSquare(x, y - 1).contains("White")))
                    list.addNode(x, y - 1);
                if (x < 8 && y < 8 && moveBoard.returnSquare(x + 1, y + 1) == "Empty")
                    list.addNode(x + 1, y + 1);
                else if (x < 8 && y < 8 && (!moveBoard.returnSquare(x + 1, y + 1).contains("White")))
                    list.addNode(x + 1, y + 1);
                if (x < 8 && y > 0 && moveBoard.returnSquare(x + 1, y - 1) == "Empty")
                    list.addNode(x + 1, y - 1);
                else if (x < 8 && y > 0 && (!moveBoard.returnSquare(x + 1, y - 1).contains("White")))
                    list.addNode(x + 1, y - 1);
                if (x > 0 && y < 8 && moveBoard.returnSquare(x - 1, y + 1) == "Empty")
                    list.addNode(x - 1, y + 1);
                else if (x > 0 && y < 8 && (!moveBoard.returnSquare(x - 1, y + 1).contains("White")))
                    list.addNode(x - 1, y + 1);
                if (x > 0 && y > 0 && moveBoard.returnSquare(x - 1, y - 1) == "Empty")
                    list.addNode(x - 1, y - 1);
                else if (x > 0 && y > 0 && (!moveBoard.returnSquare(x - 1, y - 1).contains("White")))
                    list.addNode(x - 1, y - 1);
                return list;

            case 15: // Black Right Bishop Moves
                for (int e = x + 1, i = y + 1; e < 8 && i < 8; e++, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x + 1, i = y - 1; e < 8 && i >= 0; e++, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y + 1; e >= 0 && i < 8; e--, i++) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                for (int e = x - 1, i = y - 1; e >= 0 && i >= 0; e--, i--) {
                    if (moveBoard.returnSquare(e, i) == "Empty")
                        list.addNode(e, i);
                    else if (e < 8 && i < 8 && (!moveBoard.returnSquare(e, i).contains("White"))) {
                        list.addNode(e, i);
                        break;
                    } else if (moveBoard.returnSquare(e, i) != "Empty")
                        break;
                }
                return list;

            case 16: // Black Right Knight Moves
                if (x < 6 && y < 7 && moveBoard.returnSquare(x + 2, y + 1) == "Empty")
                    list.addNode(x + 2, y + 1);
                else if (x < 6 && y < 7 && (!moveBoard.returnSquare(x + 2, y + 1).contains("White")))
                    list.addNode(x + 2, y + 1);
                if (x < 6 && y > 0 && moveBoard.returnSquare(x + 2, y - 1) == "Empty")
                    list.addNode(x + 2, y - 1);
                else if (x < 6 && y > 0 && (!moveBoard.returnSquare(x + 2, y - 1).contains("White")))
                    list.addNode(x + 2, y - 1);
                if (x < 7 && y < 6 && moveBoard.returnSquare(x + 1, y + 2) == "Empty")
                    list.addNode(x + 1, y + 2);
                else if (x < 7 && y < 6 && (!moveBoard.returnSquare(x + 1, y + 2).contains("White")))
                    list.addNode(x + 1, y + 2);
                if (x < 7 && y > 1 && moveBoard.returnSquare(x + 1, y - 2) == "Empty")
                    list.addNode(x + 1, y - 2);
                else if (x < 7 && y > 1 && (!moveBoard.returnSquare(x + 1, y - 2).contains("White")))
                    list.addNode(x + 1, y - 2);
                if (x > 1 && y < 7 && moveBoard.returnSquare(x - 2, y + 1) == "Empty")
                    list.addNode(x - 2, y + 1);
                else if (x > 1 && y < 7 && (!moveBoard.returnSquare(x - 2, y + 1).contains("White")))
                    list.addNode(x - 2, y + 1);
                if (x > 1 && y < 0 && moveBoard.returnSquare(x - 2, y - 1) == "Empty")
                    list.addNode(x - 2, y - 1);
                else if (x > 1 && y > 0 && (!moveBoard.returnSquare(x - 2, y - 1).contains("White")))
                    list.addNode(x - 2, y - 1);
                if (x > 0 && y < 6 && moveBoard.returnSquare(x - 1, y + 2) == "Empty")
                    list.addNode(x - 1, y + 2);
                else if (x > 0 && y < 6 && (!moveBoard.returnSquare(x - 1, y + 2).contains("White")))
                    list.addNode(x - 1, y + 2);
                if (x > 0 && y > 1 && moveBoard.returnSquare(x - 1, y - 2) == "Empty")
                    list.addNode(x - 1, y - 2);
                else if (x > 0 && y > 1 && (!moveBoard.returnSquare(x - 1, y - 2).contains("White")))
                    list.addNode(x - 1, y - 2);
                return list;

            case 17: // Black Right Rook Moves
                for (int i = x + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x < 8) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = x - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(i, y) == "Empty")
                        list.addNode(i, y);
                    else if ((x >= 0) && (!moveBoard.returnSquare(i, y).contains("White"))) {
                        list.addNode(i, y);
                        break;
                    } else if (moveBoard.returnSquare(i, y) != "Empty")
                        break;
                }
                for (int i = y + 1; i < 8; i++) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                for (int i = y - 1; i >= 0; i--) {
                    if (moveBoard.returnSquare(x, i) == "Empty")
                        list.addNode(x, i);
                    else if ((x >= 0) && (!moveBoard.returnSquare(x, i).contains("White"))) {
                        list.addNode(x, i);
                        break;
                    } else if (moveBoard.returnSquare(x, i) != "Empty")
                        break;
                }
                return list;

            case 18: // Black Pawn Moves
                if (x != 0 && moveBoard.returnSquare(x - 1, y) == "Empty")
                    list.addNode(x - 1, y);
                if (x == 6 && moveBoard.returnSquare(x - 1, y) == "Empty" && moveBoard.returnSquare(x - 2, y) == "Empty")
                    list.addNode(x - 2, y);
                if (x != 0 && y != 7 && moveBoard.returnSquare(x - 1, y + 1) != "Empty")
                    list.addNode(x - 1, y + 1);
                if (x != 0 && y != 0 && moveBoard.returnSquare(x - 1, y - 1) != "Empty")
                    list.addNode(x - 1, y - 1);
                return list;

            case 19: // Empty Square
                return list;
        }
    }

    public bool checkCalculator(int x, int y, Board moveBoard) {

        LinkedList * temp;
        Vector<int> moveVector;
        Vector<int> returnedVector;

        for (int e = 0; e < 8; e++) {
            for (int i = 0; i < 8; i++) {
                temp = possibleSquares2DArray(e, i, moveBoard);
                returnedVector = temp.returnVector();
                moveVector.addAll(returnedVector);
            }
        }
        for (int i = 0; i < moveVector.size(); i) {
            int a = moveVector.get(i);
            int b = moveVector.get(i + 1);
            i = i + 2;
            if (x == a && y == b) {
                return true;
            }
        }
        return false;
    }
}