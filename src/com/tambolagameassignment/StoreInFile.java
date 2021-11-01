package com.tambolagameassignment;

import java.io.FileWriter;
import java.io.IOException;

public class StoreInFile implements Runnable {

    FileWriter storeInFile;
    static StoreInFile storeIntoFile = new StoreInFile();
    static Thread storeInFileThread = new Thread(storeIntoFile);

    public void run() {
        try {
            storeInFile = new FileWriter("C:\\Users\\Jadon\\IdeaProjects\\TambolaGameAssignment\\src\\com\\tambolagameassignment\\StoreRandomNumber.txt");
            storeInFile.write(TambolaBoard.allBoardValues + "\n");
            System.out.println("All the moved random numbers are stored in the file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                storeInFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}