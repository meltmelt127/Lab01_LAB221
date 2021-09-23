/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Food;
import data.FoodList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.StringTokenizer;

/**
 *
 * @author MeltMelt
 */
public class FileUtils {

    public static FoodList readFoodListFromFile(String fName) {
        File f = null;
        FileReader fr = null;
        BufferedReader bf = null;
        FoodList list = new FoodList();
        try {
            f = new File(fName);
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ",");
                String id = stk.nextToken().toUpperCase().trim();
                String name = stk.nextToken().toUpperCase().trim();
                int weight = Integer.parseInt(stk.nextToken().trim());
                String type = stk.nextToken().trim();
                String place = stk.nextToken().trim();
                LocalDate date = LocalDate.parse(stk.nextToken().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Food food = new Food(id, name, weight, type, place, date);
                list.add(food);
            }
        } catch (IOException | NumberFormatException | DateTimeParseException e) {
            System.out.println(e);
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public static void saveToFile(String fName, FoodList list) {
        File f = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            f = new File(fName);
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            for (Food food : list) {
                pw.println(food.toString());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
