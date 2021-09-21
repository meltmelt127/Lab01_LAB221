/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.util.Calendar;
import java.sql.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class Utils {
    public static boolean getBool(String message) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        boolean result = true;
        System.out.println(message);
        inputStr = sc.nextLine().trim().toUpperCase();
        if (inputStr.startsWith("T")) result = true;
        else result = false;
        return result;
    }
    
    public static String getString(String message) {
        String result = "";
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.print(message);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                result = tmp;
                check = false;
            }
        } while (check);
        return result;
    }
    
   
    public static int getPosInt(String message) {
        int result = 0;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            try {
                System.out.print(message);
                result = Integer.parseInt(sc.nextLine());
                if (result >= 0) 
                    check = false;
                else System.out.println("Please input a positive integer!");
            } catch (Exception e) {
                System.out.println("Please input a positive integer!");
            }
        } while (check);
        return result;
    }
    
    public static java.sql.Date getDate() {
        Date result = new Date(System.currentTimeMillis());
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            String inputStr;
            System.out.print("Input a date value (yyyy/mm/dd): ");
            inputStr = sc.nextLine().replace(" ", "");
            long t = toDate(inputStr);
            if (t < 0)
                System.out.println("Inputted date is invalid!");
            else {
                result = new Date(t);
                check = false;
            }
        } while (check);
        return result;   
    }
    
    private static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0))) 
                result = true;
        return result;
    }
    
    private static boolean valid (int y, int m, int d) {
        if (y < 1 || m < 1 || m > 12 || d < 1 || d > 31) 
            return false;
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) maxD = 30;
        else if (m == 2) {
            if (isLeap(y)) maxD = 29;
            else maxD = 28;
        } 
        return d <= maxD;
    }
    
    private static long toDate(String ymd) {
        StringTokenizer stk = new StringTokenizer(ymd, "/");
        int d, m, y;
        try {
            y = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            d = Integer.parseInt(stk.nextToken());
        } catch (Exception e) {
            return -1;
        }
        if (!valid(y, m, d))
            return -1;
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        long t = cal.getTime().getTime();
        return t;
    }
}
