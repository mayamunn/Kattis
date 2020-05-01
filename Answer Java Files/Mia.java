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
        //mia
        
        Scanner scan = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<>();
        String numbers = "";

        while (!numbers.equalsIgnoreCase("0 0 0 0")) {
            numbers = scan.nextLine();
            
            if (!numbers.equalsIgnoreCase("0 0 0 0")) {
                String[] split = numbers.split(" ");
                int s0 = Integer.parseInt(split[0]);
                int s1 = Integer.parseInt(split[1]);
                int r0 = Integer.parseInt(split[2]);
                int r1 = Integer.parseInt(split[3]);
                
                int sScore = 0;
                int sAddedNum = 0;
                int rScore = 0;
                int rAddedNum = 0;
                
                if ((s0 == 1 && s1 == 2) || (s1 == 1 && s0 == 2)) {
                    sScore = 1;
                }
                else if (s0 == s1) {
                    sScore = 2;
                    sAddedNum = s0 * 10 + s1;
                }
                else {
                    if (s1 > s0) {
                        sAddedNum = (s1 * 10) + s0;
                        sScore = 3;
                    }
                    else {
                        sAddedNum = (s0 * 10) + s1;
                        sScore = 3;
                    }
                }
                
                if ((r0 == 1 && r1 == 2) || (r1 == 1 && r0 == 2)) {
                    rScore = 1;
                }
                else if (r0 == r1) {
                    rScore = 2;
                    rAddedNum = r0 * 10 + r1;
                }
                else {
                    if (r1 > r0) {
                        rAddedNum = (r1 * 10) + r0;
                        rScore = 3;
                    }
                    else {
                        rAddedNum = (r0 * 10) + r1;
                        rScore = 3;
                    }
                }
                
                String thisResult = "";
                String player1 = "Player 1 wins.";
                String player2 = "Player 2 wins.";
                String tie = "Tie.";
                
                switch (sScore) {
                    case 1:
                        if (rScore == 1) {
                            thisResult = tie;
                        }
                        else {
                            thisResult = player1;
                        }   break;
                    case 2:
                        if (rScore == 1) {
                            thisResult = player2;
                        }
                        else if (rScore == 2) {
                            if (sAddedNum > rAddedNum) {
                                thisResult = player1;
                            }
                            else if (sAddedNum == rAddedNum) {
                                thisResult = tie;
                            }
                            else {
                                thisResult = player2;
                            }
                        }
                        else {
                            thisResult = player1;
                        }
                        break;
                    case 3:
                        if (rScore != 3) {
                            thisResult = player2;
                        }
                        else {
                            if (sAddedNum > rAddedNum) {
                                thisResult = player1;
                            }
                            else if (sAddedNum == rAddedNum) {
                                thisResult = tie;
                            }
                            else {
                                thisResult = player2;
                            }
                        }
                        break;
                }
                
                results.add(thisResult);
            }
                
        }
        
        
        
        for (String result : results) {
            System.out.println(result);
        }
    }
}

