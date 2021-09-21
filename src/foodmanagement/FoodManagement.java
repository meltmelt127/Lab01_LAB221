/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;

import data.FoodList;
import method.Menu;

/**
 *
 * @author Admin
 */
public class FoodManagement {

   
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addMenuItem();
        int userChoice;
        FoodList list = new FoodList();
        do {
            menu.printMenu();
            userChoice = menu.getChoice("Choose option: ");
            switch (userChoice) {
                case 1:
                    list.addFood();
                    break;
                case 2:
                    list.searchFood();
                    break;
                case 3:
                    list.removeFood();
                    break;
                case 4:
                    list.printFood();
                    break;
            }
        } while (userChoice != 5);
    }
    
}
