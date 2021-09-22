/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu extends ArrayList{
    public void addMenuItem() {
        this.add("Add a new food");
        this.add("Search a food by name");
        this.add("Remove the food by ID");
        this.add("Print the food list in the descending order of expired date");
        this.add("Quit");
    }
    public void printMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "- " + this.get(i));
        }
    }
    
    public static int getChoice(String message) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                if (result > 0 && result < 6) 
                    return result;
                else System.out.println("Please input an integer from 1 to 5!");
            } catch (NumberFormatException e) {
                System.out.println("Please input an integer from 1 to 5!");
            }
        } while (true);
    }
}
