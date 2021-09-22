/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class InputUtils {
    public static boolean getBool(String message) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        System.out.print(message);
        inputStr = sc.nextLine().trim().toUpperCase();
        //input from user accept "Y"
        return inputStr.startsWith("Y");
    }
    
    public static String getString(String message) {
        String result;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message);
            result = sc.nextLine();
            if (!result.trim().isEmpty()) {
                return result;
            }
        } while (true);
    }
    
   
    public static int getPositiveInteger(String message) {
        Scanner sc = new Scanner(System.in);
        int result;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                if (result >= 0) 
                    return result;
                System.out.println("Please input a positive integer!");
            } catch (NumberFormatException e) {
                System.out.println("Please input a positive integer!");
            }
        } while (true);
    }
    
    public static LocalDate getDate() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Input a date value (yyyy-mm-dd): ");
                return LocalDate.parse(sc.nextLine().replace(" ", ""));
            } catch (DateTimeParseException e) {
                System.out.println("Please input the correct format");
            }
        } while (true);
    }
}
