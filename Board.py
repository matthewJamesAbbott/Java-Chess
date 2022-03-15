class Board(object):

    __board = []
    temp = []
    for x in range(0, 8):
        for y in range(0, 8):
            temp.append("Empty")
        __board.append(temp)
        temp = []

    #def __init__(self):

    #def __del__(self):

    def returnSquare(self,x , y):
        return self.__board[x][y]

    def setSquare(self, x, y, piece):
        self.__board[x][y] = piece


