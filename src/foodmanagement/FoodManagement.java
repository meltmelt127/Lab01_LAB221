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
 * @author MeltMelt
 */
public class FoodManagement {

    private static final String FILE_NAME = "foods.txt";

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addMenuItem();
        int userChoice;
        boolean changed = false;
        String fileNameToSave;
        FoodList list = FileUtils.readFoodListFromFile(FILE_NAME);
        do {
            menu.printMenu();
            userChoice = menu.getChoice("Choose option: ");
            switch (userChoice) {
                case 1:
                    list.addFood();
                    changed = true;
                    break;
                case 2:
                    list.searchFood();
                    break;
                case 3:
                    list.removeFood();
                    changed = true;
                    break;
                case 4:
                    list.printFood();
                    changed = true;
                    break;
                case 5:
                    fileNameToSave = InputUtils.getFileName("Input the the file name you want to save (format: <<filename>>.txt): ");
                    FileUtils.saveToFile(fileNameToSave, list);
                    System.out.println("Saved.");
                case 6:
                    if (changed) 
                        if (InputUtils.getBool("Save changes? (Y/N): ")) {
                            fileNameToSave = InputUtils.getFileName("Input the the file name you want to save (format: <<filename>>.txt): ");
                            FileUtils.saveToFile(fileNameToSave, list);
                            System.out.println("Saved.");
                        }
            }
        } while (userChoice != 6);
    }

}
