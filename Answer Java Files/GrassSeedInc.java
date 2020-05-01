/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kattis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Kattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1st num = cost of seed per m2
        //2nd num = number of lawns to sow
        //one line per lawn to sow
            //1st num width
            //2nd num height
        
        Scanner scan = new Scanner(System.in);
        double cost = Double.parseDouble(scan.nextLine());
        int numOfLawns = Integer.parseInt(scan.nextLine());
        
        double totalCost = 0;
        for (int i = 0; i < numOfLawns; i++) {
            String dimensions = scan.nextLine();
            String[] split = dimensions.split(" ");
            double width = Double.parseDouble(split[0]);
            double height = Double.parseDouble(split[1]);
            
            double area = width * height;
            totalCost += area * cost;
        }
        
        System.out.printf("%.7f", totalCost);
    }
}

