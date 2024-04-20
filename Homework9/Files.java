package Homework9;

import java.io.IOException;
import java.util.Scanner;

public class Files {
    public static int readInt(String message) throws Exception {
        System.out.println(message);
        Scanner scan = new Scanner(System.in);
        try {
            readFile();
            Integer.parseInt(String.valueOf(scan.next()));
        } catch (IOException e) {
            System.out.println("Не число попробуйте еще раз");
        }
        return 0;
    }

    private static void readFile() throws IOException {
        throw new IOException();
    }

}
