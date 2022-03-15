import sys, getopt, socket

from Game import Game

PORT = 9008


def main():
    args = sys.argv[1:]
    chess = Game()
    if (len(args) == 0):
        chess.clientServerToggle = 0
    else:
        if (args[0] == "-s"):
            print("Game is now running as server and waiting for a client too connect")
            chess.clientServerToggle = 1
        elif (args[0] == "-c"):
            chess.clientServerToggle = 2
        elif (args[0] == "--help"):
            print("Usage: Chess [OPTION] ... [IP ADDRESS]\n" + \
                  "Chess will run with no argument as a standalone game or with options as client and server\n" + \
                "   -s                  run Chess as server\n" + \
                "   -c [IP ADDRESS]     run Chess as client connecting to [IP ADDRESS]")


    x = ''
    xa = ''
    y = ''
    ya = ''

    if (chess.clientServerToggle == 2):
        chess.initialiseBoard()
        chess.printBoardToTerminal()
        clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        clientSocket.connect(("127.0.0.1", PORT))
        while (True):
            while (True):
                print("Please enter number for piece you wish to move or 9 too exit")
                x = int(input())
                if (x == 1 or x == 2 or x == 3 or x == 4 or x == 5 or x == 6 or x == 7 or x == 8):
                    break
                elif (x == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    x = 0

            while (True):
                print("Please enter letter for piece you wish to move or 9 too exit")
                y = input()
                if (y == 'a' or y == 'A' or y == 'b' or y == 'B' or y == 'c' or y == 'C' or y == 'd' or y == 'D'
                        or y == 'e' or y == 'E' or y == 'f' or y == 'F' or y == 'g' or y == 'G' or y == 'h' or y == 'H'):
                    break
                elif (y == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    y = 0
            while (True):
                print("Please enter number for were you wish piece to move too or 9 too exit")
                xa = int(input())
                if (xa == 1 or xa == 2 or xa == 3 or xa == 4 or xa == 5 or xa == 6 or xa == 7 or xa == 8):
                    break
                elif (xa == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    xa = 0
            while (True):
                print("Please enter letter for were you wish piece to move too or 9 too exit")
                ya = input()
                if (ya == 'a' or ya == 'A' or ya == 'b' or ya == 'B' or ya == 'c' or ya == 'C' or ya == 'd' or ya == 'D'
                        or ya == 'e' or ya == 'E' or ya == 'f' or ya == 'F' or ya == 'g' or ya == 'G' or ya == 'h' or
                        ya == 'H'):
                    break
                elif (ya == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    ya = 0
            chess.movePiece(x, y, xa, ya)
            chess.printBoardToTerminal()

            inputString = str(x) + y + str(xa) + ya


            clientSocket.send(inputString.encode())
            receiveMessage = clientSocket.recv(128).decode("utf-8", "ignore")

            a = int(receiveMessage[0])
            b = int(receiveMessage[2])

            chess.movePiece(a, receiveMessage[1], b, receiveMessage[3])
            chess.printBoardToTerminal()

    if(chess.clientServerToggle == 1):
        chess.initialiseBoard()
        chess.printBoardToTerminal()
        serverSocketHandler = socket.socket(socket.AF_INET , socket.SOCK_STREAM)

        serverSocketHandler.bind(("127.0.0.1", PORT))

        serverSocketHandler.listen(5)
        conn, addr = serverSocketHandler.accept()

        while (True):
            receiveMessage = conn.recv(128)

            a = int(receiveMessage[0])
            b = int(receiveMessage[2])

            chess.movePiece(a, receiveMessage[1], b, receiveMessage[3])
            chess.printBoardToTerminal()
            while (True):
                print("Please enter number for piece you wish to move or 9 too exit")
                x = input()
                if (x == 1 or x == 2 or x == 3 or x == 4 or x == 5 or x == 6 or x == 7 or x == 8):
                    break
                elif (x == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    x = 0


            while (True):
                print("Please enter letter for piece you wish to move or 9 too exit")
                y = input()
                if (y == 'a' or y == 'A' or y == 'b' or y == 'B' or y == 'c' or y == 'C' or y == 'd' or y == 'D'
                    or y == 'e' or y == 'E' or y == 'f' or y == 'F' or y == 'g' or y == 'G' or y == 'h' or y == 'H'):
                    break
                elif (y == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    y = 0


            while (True):
                print("Please enter number for were you wish piece to move too or 9 too exit")
                xa = input()
                if (xa == 1 or xa == 2 or xa == 3 or xa == 4 or xa == 5 or xa == 6 or xa == 7 or xa == 8):
                    break
                elif (xa == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    xa = 0


            while (True):
                print("Please enter letter for were you wish piece to move too or 9 too exit")
                ya = input()
                if (ya == 'a' or ya == 'A' or ya == 'b' or ya == 'B' or ya == 'c' or ya == 'C' or ya == 'd' or ya == 'D'
                    or ya == 'e' or ya == 'E' or ya == 'f' or ya == 'F' or ya == 'g' or ya == 'G' or ya == 'h' or
                    ya == 'H'):
                    break
                elif (ya == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    ya = 0


            chess.movePiece(int(x), y, int(xa), ya)
            chess.printBoardToTerminal()
            inputString = "    "
            inputString[0] = x
            inputString[1] = y
            inputString[2] = xa
            inputString[3] = ya
            serverSocketHandler.send(inputString)

    else:
        x = ''
        xa = ''
        y = ''
        ya = ''
        chess.initialiseBoard()
        chess.printBoardToTerminal()
        while (True):
            while (True):
                print("Please enter number for piece you wish to move or 9 too exit")
                x = int(input())
                if (x == 1 or x == 2 or x == 3 or x == 4 or x == 5 or x == 6 or x == 7 or x == 8):
                    break
                elif (x == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    x = 0
        
    
            while (True):
                print("Please enter letter for piece you wish to move or 9 too exit")
                y = input()
                if (y == 'a' or y == 'A' or y == 'b' or y == 'B' or y == 'c' or y == 'C' or y == 'd' or y == 'D'
                    or y == 'e' or y == 'E' or y == 'f' or y == 'F' or y == 'g' or y == 'G' or y == 'h' or y == 'H'):
                    break
                elif (y == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    y = 0
            while (True):
                print("Please enter number for were you wish piece to move too or 9 too exit")
                xa = int(input())
                if (xa == 1 or xa == 2 or xa == 3 or xa == 4 or xa == 5 or xa == 6 or xa == 7 or xa == 8):
                    break
                elif (xa == 9):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    xa = 0
            while (True):
                print("Please enter letter for were you wish piece to move too or 9 too exit")
                ya = input()
                if (ya == 'a' or ya == 'A' or ya == 'b' or ya == 'B' or ya == 'c' or ya == 'C' or ya == 'd' or ya == 'D'
                    or ya == 'e' or ya == 'E' or ya == 'f' or ya == 'F' or ya == 'g' or ya == 'G' or ya == 'h' or ya == 'H'):
                    break
                elif (ya == '9'):
                    return 0
                else:
                    print("You have entered an illegal character please try again")
                    ya = 0

            chess.movePiece(x, y, xa, ya)
            chess.printBoardToTerminal()

main()