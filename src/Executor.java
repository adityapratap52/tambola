package com.tambolagameassignment;

public class Executor implements Runnable {

    static Player player1;
    static Player player2;

    public void run() {
        player1 = new Player();
        player2 = new Player();

        TambolaBoard.randomNoGenerator();                                             // Generate 90 Random number

        System.out.print(" ---------Player1 Ticket--------" + "\n | ");
        player1.showTicket();
        System.out.print(" ---------Player2 Ticket--------" + "\n | ");
        player2.showTicket();
        Checker checker = new Checker();
        Thread checkerThread = new Thread(checker);
        checkerThread.start();
        try {
            checkerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TambolaBoard.showStoreValues();

        System.out.print("\n ---------Player1 Ticket--------" + "\n | ");
        Executor.player1.showTicket();
        System.out.print(" ---------Player2 Ticket--------" + "\n | ");
        Executor.player2.showTicket();

    }

    public static void main(String[] args) {
        Executor dealer = new Executor();
        Thread dealerThread = new Thread(dealer);
        dealerThread.start();
    }
}