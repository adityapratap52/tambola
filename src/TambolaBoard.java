package com.tambolagameassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TambolaBoard {

    static String[] storeRandomNumber;
    static ArrayList<Integer> allBoardValues = new ArrayList<>();


    static public void randomNoGenerator() {
        storeRandomNumber = new String[90];

        for (int index = 0; index < storeRandomNumber.length; index++) {
            storeRandomNumber[index] = (index + 1) + "";
        }
        Collections.shuffle(Arrays.asList(storeRandomNumber));
        System.out.println("Board has created");
    }

    static public void showStoreValues() {

        int number = 1;
        System.out.println("\n\n**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*Total Number Store in TambolaTable*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**\n");
        for (Integer integer : allBoardValues) {
            System.out.print(integer + ", ");
            if (number % 40 == 0) {
                System.out.println();
            }
            number++;
        }
    }
}