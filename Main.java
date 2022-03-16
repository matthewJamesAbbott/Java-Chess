package xyz.squig;

import java.io.*;
import java.net.*;
import java.util.*;

public class Main {


    private static final int MAX = 80;
    private static final int PORT = 9008;


    public static void main(String[] args) throws IOException{
        System.out.println("test");

        Game chess = new Game();

        if (args.length == 0) {
            chess.clientServerToggle = 0;
        } else {
            for (int i = 0; i < args.length; i++) {
                if (args[i] == "-s") {
                    System.out.println("Game is now running as server and waiting for a client too connect");
                    chess.clientServerToggle = 1;

                }
                if (args[i] == "-c") {
                    chess.clientServerToggle = 2;
                }
                if (args[i] == "--help") {
                    System.out.println("Usage: Chess [OPTION] ... [IP ADDRESS]\n" +
                            "Chess will run with no argument as a standalone game or with options as client and server\n" +
                            "   -s                  run Chess as server\n" +
                            "   -c [IP ADDRESS]     run Chess as client connecting to [IP ADDRESS]");
                }
            }
        }
        int x, xa;
        char y, ya;
        if (chess.clientServerToggle == 2) {
            chess.initialiseBoard();
            chess.printBoardToTerminal();
            Socket s = new Socket(args[1], PORT);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());


            Scanner inputScanner = new Scanner(System.in);
            char in;
            while (true) {
                while (true) {
                    System.out.println("Please enter number for piece you wish to move or 9 too exit");

                    in = inputScanner.findInLine(".").charAt(0);
                    x = in - '0';
                    if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 || x == 8) {
                        break;
                    } else if (x == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        x = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for piece you wish to move or 9 too exit");
                    inputScanner.nextLine();
                    y = inputScanner.findInLine(".").charAt(0);
                    if (y == 'a' || y == 'A' || y == 'b' || y == 'B' || y == 'c' || y == 'C' || y == 'd' || y == 'D'
                            || y == 'e' || y == 'E' || y == 'f' || y == 'F' || y == 'g' || y == 'G' || y == 'h' || y == 'H') {
                        break;
                    } else if (y == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        y = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter number for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    in = inputScanner.findInLine(".").charAt(0);
                    xa = in - '0';
                    if (xa == 1 || xa == 2 || xa == 3 || xa == 4 || xa == 5 || xa == 6 || xa == 7 || xa == 8) {
                        break;
                    } else if (xa == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        xa = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    ya = inputScanner.findInLine(".").charAt(0);
                    if (ya == 'a' || ya == 'A' || ya == 'b' || ya == 'B' || ya == 'c' || ya == 'C' || ya == 'd' || ya == 'D'
                            || ya == 'e' || ya == 'E' || ya == 'f' || ya == 'F' || ya == 'g' || ya == 'G' || ya == 'h' ||
                            ya == 'H') {
                        break;
                    } else if (ya == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        ya = 0;
                    }
                }
                inputScanner.nextLine();
                chess.movePiece(x, y, xa, ya);
                chess.printBoardToTerminal();

                char[] input = new char[4];
                input[0] = (char)(x + '0');
                input[1] = y;
                input[2] = (char)(xa + '0');
                input[3] = ya;

                String sendMessage = new String(input);

                dout.writeUTF(sendMessage);
                dout.flush();

                String receiveMessage = new String();
                receiveMessage = (String)din.readUTF();


                int a = receiveMessage.charAt(0) - '0';
                int b = receiveMessage.charAt(2) - '0';


                chess.movePiece(a, receiveMessage.charAt(1), b, receiveMessage.charAt(3));
                chess.printBoardToTerminal();
            }

        }


        if (chess.clientServerToggle == 1) {
            chess.initialiseBoard();
            chess.printBoardToTerminal();
            ServerSocket ss=new ServerSocket(PORT);
            Socket s=ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            Scanner inputScanner = new Scanner(System.in);

            char in;
            while (true) {
                String receiveMessage = new String();
                receiveMessage = (String)din.readUTF();


                int a = receiveMessage.charAt(0) - '0';
                int b = receiveMessage.charAt(2) - '0';


                chess.movePiece(a, receiveMessage.charAt(1), b, receiveMessage.charAt(3));
                chess.printBoardToTerminal();
                while (true) {
                    System.out.println("Please enter number for piece you wish to move or 9 too exit");

                    in = inputScanner.findInLine(".").charAt(0);
                    x = in - '0';
                    if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 || x == 8) {
                        break;
                    } else if (x == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        x = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for piece you wish to move or 9 too exit");
                    inputScanner.nextLine();
                    y = inputScanner.findInLine(".").charAt(0);
                    if (y == 'a' || y == 'A' || y == 'b' || y == 'B' || y == 'c' || y == 'C' || y == 'd' || y == 'D'
                            || y == 'e' || y == 'E' || y == 'f' || y == 'F' || y == 'g' || y == 'G' || y == 'h' || y == 'H') {
                        break;
                    } else if (y == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        y = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter number for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    in = inputScanner.findInLine(".").charAt(0);
                    xa = in - '0';
                    if (xa == 1 || xa == 2 || xa == 3 || xa == 4 || xa == 5 || xa == 6 || xa == 7 || xa == 8) {
                        break;
                    } else if (xa == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        xa = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    ya = inputScanner.findInLine(".").charAt(0);
                    if (ya == 'a' || ya == 'A' || ya == 'b' || ya == 'B' || ya == 'c' || ya == 'C' || ya == 'd' || ya == 'D'
                            || ya == 'e' || ya == 'E' || ya == 'f' || ya == 'F' || ya == 'g' || ya == 'G' || ya == 'h' ||
                            ya == 'H') {
                        break;
                    } else if (ya == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        ya = 0;
                    }
                }
                inputScanner.nextLine();
                chess.movePiece(x, y, xa, ya);
                chess.printBoardToTerminal();

                char[] input = new char[4];
                input[0] = (char)(x + '0');
                input[1] = y;
                input[2] = (char)(xa + '0');
                input[3] = ya;

                String sendMessage = new String(input);

                dout.writeUTF(sendMessage);
                dout.flush();
            }
        }

        if (chess.clientServerToggle == 0) {
            chess.initialiseBoard();
            chess.printBoardToTerminal();
            Scanner inputScanner = new Scanner(System.in);
            char in;
            while (true) {
                while (true) {
                    System.out.println("Please enter number for piece you wish to move or 9 too exit");

                    in = inputScanner.findInLine(".").charAt(0);
                    x = in - '0';

                    if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7 || x == 8) {
                        break;
                    } else if (x == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        x = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for piece you wish to move or 9 too exit");
                    inputScanner.nextLine();
                    y = inputScanner.findInLine(".").charAt(0);
                    if (y == 'a' || y == 'A' || y == 'b' || y == 'B' || y == 'c' || y == 'C' || y == 'd' || y == 'D'
                            || y == 'e' || y == 'E' || y == 'f' || y == 'F' || y == 'g' || y == 'G' || y == 'h' || y == 'H') {
                        break;
                    } else if (y == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        y = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter number for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    in = inputScanner.findInLine(".").charAt(0);
                    xa = in - '0';
                    if (xa == 1 || xa == 2 || xa == 3 || xa == 4 || xa == 5 || xa == 6 || xa == 7 || xa == 8) {
                        break;
                    } else if (xa == 9)
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        xa = 0;
                    }
                }
                while (true) {
                    System.out.println("Please enter letter for were you wish piece to move too or 9 too exit");
                    inputScanner.nextLine();
                    ya = inputScanner.findInLine(".").charAt(0);
                    if (ya == 'a' || ya == 'A' || ya == 'b' || ya == 'B' || ya == 'c' || ya == 'C' || ya == 'd' || ya == 'D'
                            || ya == 'e' || ya == 'E' || ya == 'f' || ya == 'F' || ya == 'g' || ya == 'G' || ya == 'h' ||
                            ya == 'H') {
                        break;
                    } else if (ya == '9')
                        System.exit(0);
                    else {
                        System.out.println("You have entered an illegal character please try again");
                        ya = 0;
                    }

                }
                inputScanner.nextLine();
                chess.movePiece(x, y, xa, ya);
                chess.printBoardToTerminal();
            }
        }
    System.exit(0);
    }
}