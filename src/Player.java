package com.tambolagameassignment;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Player {

    HashSet<Integer> ticket;

    Player() {
        this.ticket = new HashSet<>();
        while (ticket.size() != 15) {
            int value = (int) (Math.random() * 90 + 1);
            this.ticket.add(value);
        }
    }

    public void showTicket() {
        int count = 1;
        for (Integer ticketValue : ticket) {
            int ticket_Value = it.next();
            System.out.printf("%3d  |", ticketValue);
            if (count % 5 == 0) System.out.println();
            if (count % 5 == 0 && count != 15) System.out.print(" | ");
            count++;
        }
        System.out.println(" --------------------------------");
    }

}
