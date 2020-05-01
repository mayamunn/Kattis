/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kattis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        //Multiple test cases up to 5
        //Each test case has n lines
        //last word on each line describes animal
        
        Scanner scan = new Scanner(System.in);
        String line = "";
        ArrayList<String> lines = new ArrayList<>();
        
        HashMap<String, Integer> list1 = new HashMap<>();
        HashMap<String, Integer> list2 = new HashMap<>();
        HashMap<String, Integer> list3 = new HashMap<>();
        HashMap<String, Integer> list4 = new HashMap<>();
        HashMap<String, Integer> list5 = new HashMap<>();
        int currentListNumber = 1;
        
        while (!line.equalsIgnoreCase("0")) {
            line = scan.nextLine();
            if (!line.equalsIgnoreCase("0")) {
                lines.add(line);
            }
        }
        
        for (int lineNo = 0; lineNo < lines.size(); lineNo++) {
            int number;
            String animalName;
            
            try {
                number = Integer.valueOf(lines.get(lineNo));
                HashMap<String, Integer> currentList = list1;
                
                switch (currentListNumber) {
                    case 1:
                        currentList = list1;
                        break;
                    case 2:
                        currentList = list2;
                        break;
                    case 3:
                        currentList = list3;
                        break;
                    case 4:
                        currentList = list4;
                        break;
                    case 5:
                        currentList = list5;
                        break;
                    default:
                        break;
                }
                currentListNumber++;
                
                for (int i = 0; i < number; i++) {
                    animalName = lines.get(lineNo + (i + 1));
                    String[] animalWords = animalName.split(" ");
                    String lastWord = animalWords[animalWords.length - 1].toLowerCase();
                    
                    if (currentList.containsKey(lastWord)) {
                        //Animal exists in list
                        int animalCount = currentList.get(lastWord);
                        currentList.put(lastWord, animalCount + 1);
                    }
                    else {
                        currentList.put(lastWord, 1);
                    }
                }
            }
            catch (NumberFormatException e) {
                // Do nothing
            }
        }
        
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 1:
                    if (!list1.isEmpty()) {
                        printList(1, list1);
                    }
                    break;
                case 2:
                    if (!list2.isEmpty()) {
                        printList(2, list2);
                    }
                    break;
                case 3:
                    if (!list3.isEmpty()) {
                        printList(3, list3);
                    }
                    break;
                case 4:
                    if (!list4.isEmpty()) {
                        printList(4, list4);
                    }
                    break;
                case 5:
                    if (!list5.isEmpty()) {
                        printList(5, list5);
                    }
                    break;
            }
        }
    }
    
    private static void printList(int listNumber, HashMap list) {
        System.out.println("List " + listNumber + ": ");
        
        ArrayList<String> allAnimalNames = new ArrayList<>();
        for (Object animalName : list.keySet()) {
            String name = (String) animalName;
            allAnimalNames.add(name);
        }
        
        Collections.sort(allAnimalNames);
        
        for (String animalName : allAnimalNames) {
            String toPrint = animalName;
            Object numberOfAnimals = list.get(animalName);
            int number = (Integer) numberOfAnimals;
            
            toPrint += " | " + number;
            System.out.println(toPrint);
        }
    }
}
