package Java.ristorante.src.utils;

import java.util.Scanner;

public class MyMenu {

    private static Scanner intScanner = new Scanner(System.in);
    private static Scanner strScanner = new Scanner(System.in);

    public static int intSelectionMenu(String question, String... menuOption) {

        int counter = 1;

        for (String option : menuOption) {
            System.out.println(counter + ") " + option);
            counter++;
        }
        System.out.print("\n" + question);

        return intScanner.nextInt();
    }

    public static String strSelectionMenu(String question, String... menuOption) {

        int counter = 1;

        for (String option : menuOption) {
            System.out.println(counter + ") " + option);
            counter++;
        }
        System.out.print("\n" + question);

        return strScanner.nextLine();
    }
}
