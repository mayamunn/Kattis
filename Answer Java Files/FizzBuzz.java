/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kattis;

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
        int x;  //divisible by x = fizz         //both fizzbuzz
        int y;  //divisible by y = buzz
        int n;  //1 ~ n
        
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);
        
        for (int i = 1; i <= n; i++) {
            String toPrint = Integer.toString(i);
            
            if (i % x == 0) {
                toPrint = "Fizz";
                if (i % y == 0) {
                    toPrint = "FizzBuzz";
                }
            }
            else if (i % y == 0) {
                toPrint = "Buzz";
            }
            
            System.out.println(toPrint);
        }
    }
    
}
