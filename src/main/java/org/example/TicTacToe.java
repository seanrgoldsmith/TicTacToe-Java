package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

//        Random random = new Random();
//        int selectPlayer = random.nextInt(2) + 1;
//        String player = "";
//        if (selectPlayer == 1) {
//            player = "Player";
//        } else {
//            player = "CPU";
//        }


        String[][] board = {{"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "},
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "},};

        displayBoard(board);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an open position 1-9:");
        int placement = scanner.nextInt();

        selectPosition(board, placement, "Player");

        Random cpuRand = new Random();
        int cpuPosition = cpuRand.nextInt(9) + 1;

        selectPosition(board, cpuPosition, "CPU");

        displayBoard(board);

        }
    public static void displayBoard(String[][] board) {
        for (String[] row : board) {
            for (String character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
    public static void selectPosition (String[][] board, int placement, String player) {

        String marker = "";

        if (player.equals("Player")) {
            marker = " X ";
        } else if (player.equals("CPU")) {
            marker = " O ";
        }

        switch(placement) {
            case 1:
                board[0][0] = marker;
                break;
            case 2:
                board[0][2] = marker;
                break;
            case 3:
                board[0][4] = marker;
                break;
            case 4:
                board[2][0] = marker;
                break;
            case 5:
                board[2][2] = marker;
                break;
            case 6:
                board[2][4] = marker;
                break;
            case 7:
                board[4][0] = marker;
                break;
            case 8:
                board[4][2] = marker;
                break;
            case 9:
                board[4][4] = marker;
                break;
        }
    }
    }
