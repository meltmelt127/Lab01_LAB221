/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import utils.InputUtils;

/**
 *
 * @author MeltMelt
 */
public class FoodList extends ArrayList<Food> {

    public void addFood() {
        String id, name, type, place;
        int weight;
        LocalDate expiredDate;
        int position;
        boolean isContinue;
        do {
            do {
                id = InputUtils.getString("Input ID: ").toUpperCase();
                position = this.indexOf(new Food(id));
                if (position >= 0) {
                    System.out.println("The ID is duplicated.");
                }
            } while (position >= 0);
            name = InputUtils.getString("Input Name: ").toUpperCase();
            weight = InputUtils.getPositiveInteger("Input Weight: ");
            type = InputUtils.getString("Input Type: ");
            place = InputUtils.getString("Input Place: ");
            expiredDate = InputUtils.getDate();
            this.add(new Food(id, name, weight, type, place, expiredDate));
            System.out.println("New Food has been added.");
            isContinue = InputUtils.getBool("Do you want to add another food? (Y/N): ");
        } while (isContinue);
    }

    public void searchFood() {
        String name;
        boolean isContinue, check;
        do {
            name = InputUtils.getString("Input food name which will be searched: ").toUpperCase();
            check = false;
            for (Food food : this) {
                if (food.getName().contains(name)) {
                    check = true;
                    System.out.println(food);
                }
            }
            if (!check) {
                System.out.println("This food does not exist.");
            }
            isContinue = InputUtils.getBool("Do you want to search another food? (Y/N): ");
        } while (isContinue);
    }

    public void removeFood() {
        String id = InputUtils.getString("Input food id which will be removed: ").toUpperCase();
        int position = this.indexOf(new Food(id));
        if (position < 0) {
            System.out.println("This food does not exist");
        } else {
            if (InputUtils.getBool("Are you sure you want to remove food " + id + "? (Y/N): ")) {
                this.remove(position);
                System.out.println("Food " + id + " was removed.");
            } else {
                System.out.println("Remove failed.");
            }
        }
    }

    public void printFood() {
        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpiredDate().compareTo(o1.getExpiredDate());
            }
        });
        for (Food food : this) {
            System.out.println(food);
        }
    }
}
