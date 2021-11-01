package com.tambolagameassignment;

import java.util.HashSet;
import java.util.Scanner;

public class Checker implements Runnable {

    static boolean outputAfterComparing;
    static int loopCycle;
    static int countPlayer1;
    static int countPlayer2;
    static String userAnswer;

    static boolean comparing(HashSet<Integer> ticket1, HashSet<Integer> ticket2) {
        int boardValue;
        boardValue = Integer.parseInt(TambolaBoard.storeRandomNumber[loopCycle]);
        TambolaBoard.allBoardValues.add(boardValue);

        if (userAnswer.equals("n") || userAnswer.equals("N")) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(boardValue);
        if (ticket1.contains(boardValue)) {
            System.out.println(boardValue + " is stored in Ticket1");
            if (countPlayer1 == 15) {
                System.out.println("\n Housie!  Congratulation Player1 you won the match \n");
                return false;
            }
            countPlayer1++;
        }
        if (ticket2.contains(boardValue)) {
            System.out.println(boardValue + " is stored in Ticket2");
            if (countPlayer2 == 15) {
                System.out.println("\n Housie! Congratulation Player2 you won the match \n");
                return false;
            }
            countPlayer2++;
        }
        return true;
    }

    public static void playerCheckTicket() {
        outputAfterComparing = true;
        countPlayer1 = 1;
        countPlayer2 = 1;
        loopCycle = 0;

        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to User interaction : y/n");
        userAnswer = sc.nextLine();

        switch (userAnswer) {
            case "y":
            case "Y":

                String enterKey;
                do {
                    enterKey = sc.nextLine();
                    if (!enterKey.equals("")) {
                        System.err.println("\nYou can't press the other keywords! Please Restart the game");
                        System.exit(0);
                    }
                    outputAfterComparing = comparing(Executor.player1.ticket, Executor.player2.ticket);
                    loopCycle++;
                    System.out.println("===============================================================");
                } while (loopCycle != 90 && outputAfterComparing);
                break;

            case "n":
            case "N":
                while (loopCycle != 90 && outputAfterComparing) {
                    outputAfterComparing = comparing(Executor.player1.ticket, Executor.player2.ticket);
                    loopCycle++;
                    System.out.println("===============================================================");
                }
                break;

            case "":
                System.err.println("You can't use Enter key at this time! Please Restart the game");
                System.exit(0);

            default:
                System.err.println("You entered wrong key");
                System.exit(0);
        }
        StoreInFile.storeInFileThread.start();
        try {
            StoreInFile.storeInFileThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        playerCheckTicket();
    }
}