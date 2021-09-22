/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmanagement;

import data.FoodList;
import UI.Menu;
import utils.FileUtils;
import utils.InputUtils;

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
        FileUtils.addFromFile("foods.txt", list);
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
                case 5:
                    FileUtils.saveToFile("foods.txt", list);
            }
        } while (userChoice != 5);
    }
    
}
