from Board import Board
from MoveCalculator import MoveCalculator
from MoveCalculator import LinkedList

class Game:
    clientServerToggle = 0
    __playerOne = ""
    __playerTwo = ""
    __gameBoard = Board()

    def initialiseBoard(self):
        self.__gameBoard.setSquare(0, 0, "White Left Rook")
        self.__gameBoard.setSquare(0, 1, "White Left Knight")
        self.__gameBoard.setSquare(0, 2, "White Left Bishop")
        self.__gameBoard.setSquare(0, 3, "White Queen")
        self.__gameBoard.setSquare(0, 4, "White King")
        self.__gameBoard.setSquare(0, 5, "White Right Bishop")
        self.__gameBoard.setSquare(0, 6, "White Right Knight")
        self.__gameBoard.setSquare(0, 7, "White Right Rook")

        for i in range(0, 8):
            self.__gameBoard.setSquare(1, i, "White Pawn")


        for e in range(2, 6):
            for i in range(0, 8):
                self.__gameBoard.setSquare(e, i, "Empty")

        for i in range(0, 8):
            self.__gameBoard.setSquare(6, i, "Black Pawn")

        self.__gameBoard.setSquare(7, 0, "Black Left Rook")
        self.__gameBoard.setSquare(7, 1, "Black Left Knight")
        self.__gameBoard.setSquare(7, 2, "Black Left Bishop")
        self.__gameBoard.setSquare(7, 3, "Black Queen")
        self.__gameBoard.setSquare(7, 4, "Black King")
        self.__gameBoard.setSquare(7, 5, "Black Right Bishop")
        self.__gameBoard.setSquare(7, 6, "Black Right Knight")
        self.__gameBoard.setSquare(7, 7, "Black Right Rook")

    def movePiece(self, ia, ca, ib, cb):

        if (ca == 'A' or ca == 'a'):
            ya = 0
        elif (ca == 'B' or ca == 'b'):
            ya = 1

        elif (ca == 'C' or ca == 'c'):
            ya = 2
        elif (ca == 'D' or ca == 'd'):
            ya = 3
        elif (ca == 'E' or ca == 'e'):
            ya = 4
        elif (ca == 'F' or ca == 'f'):
            ya = 5
        elif (ca == 'G' or ca == 'g'):
            ya = 6
        elif (ca == 'H' or ca == 'h'):
            ya = 7

        if (ia == 1):
            xa = 7
        elif (ia == 2):
            xa = 6
        elif (ia == 3):
            xa = 5
        elif (ia == 4):
            xa = 4
        elif (ia == 5):
            xa = 3
        elif (ia == 6):
            xa = 2
        elif (ia == 7):
            xa = 1
        elif (ia == 8):
            xa = 0

        if (cb == 'A' or cb == 'a'):
            yb = 0
        elif (cb == 'B' or cb == 'b'):
            yb = 1
        elif (cb == 'C' or cb == 'c'):
            yb = 2
        elif (cb == 'D' or cb == 'd'):
            yb = 3
        elif (cb == 'E' or cb == 'e'):
            yb = 4
        elif (cb == 'F' or cb == 'f'):
            yb = 5
        elif (cb == 'G' or cb == 'g'):
            yb = 6
        elif (cb == 'H' or cb == 'h'):
            yb = 7

        if (ib == 1):
            xb = 7
        elif (ib == 2):
            xb = 6
        elif (ib == 3):
            xb = 5
        elif (ib == 4):
            xb = 4
        elif (ib == 5):
            xb = 3
        elif (ib == 6):
            xb = 2
        elif (ib == 7):
            xb = 1
        elif (ib == 8):
            xb = 0

        calc = MoveCalculator()
        list = LinkedList()
        list = calc.possibleSquares2DArray(xa, ya, self.__gameBoard)
        moveVector = list.returnVector()
        for i in range(0, len(moveVector) -1):
            a = moveVector[i]
            b = moveVector[i+1]
            i = i+2
            if (xb == a and yb == b):
                originalSquare = self.__gameBoard.returnSquare(xa, ya)
                self.__gameBoard.setSquare(xb, yb, originalSquare)
                self.__gameBoard.setSquare(xa, ya, "Empty")

        return True

    def printBoardToTerminal(self):


        a = 1

        b = 3

        c = 5

        d = 7

        piece = ""
        for e in range(0, 9):
            for i in range(0, 9):
                if (e > 0 and i > 0):
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White Left Rook" or self.__gameBoard.returnSquare(e - 1, i - 1) == "White Right Rook"):
                        piece = "\u001b[97m\u265C"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White Left Knight" or self.__gameBoard.returnSquare(e - 1, i - 1) == "White Right Knight"):
                        piece = "\u001b[97m\u265E"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White Left Bishop" or self.__gameBoard.returnSquare(e - 1, i - 1) == "White Right Bishop"):
                        piece = "\u001b[97m\u265D"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White King"):
                        piece = "\u001b[97m\u265A"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White Queen"):
                        piece = "\u001b[97m\u265B"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "White Pawn"):
                        piece = "\u001b[97m\u265F"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Left Rook" or self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Right Rook"):
                        piece = "\u001b[30m\u265C"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Left Knight" or self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Right Knight"):
                        piece = "\u001b[30m\u265E"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Left Bishop" or  self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Right Bishop"):
                        piece = "\u001b[30m\u265D"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black King"):
                        piece = "\u001b[30m\u265A"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Queen"):
                        piece = "\u001b[30m\u265B"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Black Pawn"):
                        piece = "\u001b[30m\u265F"
                    if (self.__gameBoard.returnSquare(e - 1, i - 1) == "Empty"):
                        piece = " "
                    if (i == a or i == b or i == c or i == d):
                        print("\u001b[44m",  piece,  "", end="")
                    else:
                        print("\u001b[101m", piece, "", end="")

                if (i == 0):
                    if (e == 0):
                        print(" \u001b[49m  \u001b[49m \u001b[39m", end='')
                    if (e == 1):
                         print(" \u001b[43m \u001b[30m8 \u001b[49m\u001b[39m", end='')
                    if (e == 2):
                        print(" \u001b[49m \u001b[33m7 \u001b[49m\u001b[39m", end='')
                    if (e == 3):
                        print(" \u001b[43m \u001b[30m6 \u001b[49m\u001b[39m", end='')
                    if (e == 4):
                        print(" \u001b[49m \u001b[33m5 \u001b[49m\u001b[39m", end='')
                    if (e == 5):
                        print(" \u001b[43m \u001b[30m4 \u001b[49m\u001b[39m", end='')
                    if (e == 6):
                        print(" \u001b[49m \u001b[33m3 \u001b[49m\u001b[39m", end='')
                    if (e == 7):
                        print(" \u001b[43m \u001b[30m2 \u001b[49m\u001b[39m", end='')
                    if (e == 8):
                        print(" \u001b[49m\u001b[33m 1 \u001b[49m\u001b[39m", end='')



            print("\u001b[49m\u001b[39m")

            if (e == 1):
                a += 1
                b += 1
                c += 1
                d += 1
            elif (e == 2):
                a -= 1
                b -= 1
                c -= 1
                d -= 1
            elif (e == 3):
                a += 1
                b += 1
                c += 1
                d += 1
            elif (e == 4):
                a -= 1
                b -= 1
                c -= 1
                d -= 1
            elif (e == 5):
                a += 1
                b += 1
                c += 1
                d += 1
            elif (e == 6):
                a -= 1
                b -= 1
                c -= 1
                d -= 1
            elif (e == 7):
                a += 1
                b += 1
                c += 1
                d += 1


        print(" \u001b[43m  " + " \u001b[49m \u001b[33mA" + " \u001b[43m \u001b[30mB" + " \u001b[49m \u001b[33mC" + " \u001b[43m \u001b[30mD" + " \u001b[49m \u001b[33mE" + " \u001b[43m \u001b[30mF" + " \u001b[49m \u001b[33mG" + " \u001b[43m \u001b[30mH" + " \u001b[49m\u001b[39m")






