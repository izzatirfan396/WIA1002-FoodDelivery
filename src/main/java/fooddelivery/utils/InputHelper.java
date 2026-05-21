package fooddelivery.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

 //Shared utility class for safe Scanner input without buffer (USED BY ALL MODULE FOR INPUT)
public class InputHelper {

    //Reads an integer safely. Re-prompts on invalid input.
    public static int readInt(Scanner sc) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // flush buffer
                return val;
            } catch (InputMismatchException e) {
                sc.nextLine(); // clear bad input
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    //Reads a double safely. Re-prompts on invalid input.
    public static double readDouble(Scanner sc) {
        while (true) {
            try {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    //Reads a non-empty string. Re-prompts if blank.
    public static String readString(Scanner sc) {
        String val = sc.nextLine().trim();
        while (val.isEmpty()) {
            System.out.print("Input cannot be empty: ");
            val = sc.nextLine().trim();
        }
        return val;
    }
}
