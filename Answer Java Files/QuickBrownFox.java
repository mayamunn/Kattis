/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kattis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author user
 */
public class Kattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfLines = Integer.parseInt(scan.nextLine());
        
        String[] results = new String[numOfLines];
        for (int i = 0; i < numOfLines; i++) {
            ArrayList<Character> alphabet = getAlphabetStack();
            String input = scan.nextLine();
            input = input.toLowerCase();
            char[] splitLetters = input.toCharArray();
            
            for (char letter : splitLetters) {
                if (alphabet.contains(letter)) {
                    alphabet.remove(alphabet.indexOf(letter));
                }
            }
            
            String result = "";
            if (!alphabet.isEmpty()) {
                for (char letter : alphabet) {
                     result += letter + "";
                }
            }
            else {
                result = "pangram";
            }
            
            results[i] = result;
        }
        
        for (int i = 0; i < numOfLines; i++) {
            if (results[i].equalsIgnoreCase("pangram")) {
                System.out.println("pangram");
            }
            else {
                System.out.println("missing " + results[i]);
            }
        }
    }
    
    public static ArrayList getAlphabetStack() {
        ArrayList<Character> alphabet = new ArrayList<>();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        
        return alphabet;
    }
}

