/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import method.Utils;

/**
 *
 * @author Admin
 */
public class FoodList extends ArrayList<Food>{
    public void addFromFile(String fName) {
        try {
            File f = new File(fName);
            if (!f.exists())
                return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String id = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int weight= Integer.parseInt(stk.nextToken());
                String type = stk.nextToken();
                String place = stk.nextToken();
                Date date = Date.valueOf(stk.nextToken());
            }
            bf.close(); fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }   
    }
    
    public void saveToFile (String fName) {
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Food food : this) 
                pw.println(food.toString());
            pw.close(); fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private int find(String id) {
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).getId().equals(id))
                return i;
        return -1;
    }
    
    public void addFood() {
        String nId, nName, nType, nPlace;
        int nWeight;
        Date nExDate;
        int pos;
        boolean con = true;
        do {
            do {
                nId = Utils.getString("Input new ID: ").toUpperCase();
                pos = find(nId);
                if (pos >= 0)
                    System.out.println("The ID is duplicated.");
            } while (pos >= 0);
            nName = Utils.getString("Input new Name: ").toUpperCase();
            nWeight = Utils.getPosInt("Input new Weight: ");
            nType = Utils.getString("Input new Type: ");
            nPlace = Utils.getString("Input new Place: ");
            nExDate = Utils.getDate();
            this.add(new Food(nId, nName, nWeight, nType, nPlace, nExDate));
            System.out.println("New Food has been added.");
            con = Utils.getBool("Do you want to add another food? (Y/N): ");
        } while (con);
    }
    
    public void searchFood() {
        String name; 
        boolean con = true, check; 
        do {
            name = Utils.getString("Input food name which will be searched: ").toUpperCase();
            check = false;
            for (Food food : this) 
                if (name.equals(food.getName())) {
                    check = true;
                    System.out.println(food.toString());
                }
            if (!check)
                System.out.println("This food does not exist");
            con = Utils.getBool("Do you want to search another food? (Y/N): ");
        } while (con);
    }
    
    public void removeFood() {
        String id = Utils.getString("Input food id which will be removed: ").toUpperCase();
        int pos = find(id);
        if (pos < 0) 
            System.out.println("Not found!");
        else {
            this.remove(pos);
            System.out.println("Food " + id + " was removed.");
        }
    }
    
    public void printFood() {
        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return (int) (o1.getExpiredDate().getTime() - o2.getExpiredDate().getTime());
            }
        } );
        for (Food food : this) {
            System.out.println(food);
        }
    }
}
