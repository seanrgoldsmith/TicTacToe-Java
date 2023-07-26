package org.example;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
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

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an open position 1-9:");
            int playerPlacement = scanner.nextInt();

            selectPosition(board, playerPlacement, "Player");

            Random cpuRand = new Random();
            int cpuPlacement = cpuRand.nextInt(9) + 1;
            if (!playerPositions.contains(cpuPlacement)) {
                    selectPosition(board, cpuPlacement, "CPU");
                    displayBoard(board);
                    String results = checkWinConditions();
                    System.out.println(results);

            }
        }
    }
    //TODO add method to check if position is taken during CPU and Player moves
    public static boolean checkBoardState() {
        return true;
    }
    //TODO implement minimax algorithm
    public static int minimax() {
        return 0;
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
            playerPositions.add(placement);
        } else if (player.equals("CPU")) {
            marker = " O ";
            cpuPositions.add(placement);
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
            default:
                break;
        }
    }
    public static String checkWinConditions() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> middleRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);
        List<Integer> leftColumn = Arrays.asList(1, 4, 7);
        List<Integer> middleColumn = Arrays.asList(2, 5, 8);
        List<Integer> rightColumn = Arrays.asList(3, 6, 9);
        List<Integer> leftCross = Arrays.asList(1, 5, 9);
        List<Integer> rightCross = Arrays.asList(3, 5, 7);

        List<List> winConditions = new ArrayList<List>();
        winConditions.add(topRow);
        winConditions.add(middleRow);
        winConditions.add(bottomRow);
        winConditions.add(leftColumn);
        winConditions.add(middleColumn);
        winConditions.add(rightColumn);
        winConditions.add(leftCross);
        winConditions.add(rightCross);

        for (List win : winConditions) {
            if (playerPositions.containsAll(win)) {
                return "Congratulations! You win!!!";
            } else if (cpuPositions.containsAll(win)) {
                return "The CPU has bested you! Better luck next time!";
            } else if ((playerPositions.size() + cpuPositions.size() == 9)) {
                return "The game is a tie!";
            }
        }


        return "";
    }

    }
