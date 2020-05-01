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
        Scanner scan = new Scanner(System.in);
        String[] input = new String[7];
        
        for (int i = 0; i < 7; i++) {
            input[i] = scan.nextLine();
        }
        
        String equationInString = "";
        for (int i = 0; i < input[0].length(); i += 6) {
            
            String currentSegment = "";
            char[] currentSegmentArray = input[0].toCharArray();
            for (int j = 0; j < 5; j++) {
                currentSegment += currentSegmentArray[i + j];
            }
            
            if (currentSegment.equalsIgnoreCase(".....")) { 
                equationInString += "+";
            }
            else if (currentSegment.equalsIgnoreCase("....x")) {
                equationInString += "1";
            }
            else if (currentSegment.equalsIgnoreCase("x...x")) {
                equationInString += "4";
            }
            else {
                //0, 2, 3, 5, 6, 7, 8, 9
                currentSegment = "";
                currentSegmentArray = input[1].toCharArray();
                for (int j = 0; j < 5; j++) {
                    currentSegment += currentSegmentArray[i + j];
                }
                
                if (currentSegment.equalsIgnoreCase("x...x")) {
                    //0, 8, 9
                    currentSegment = "";
                    currentSegmentArray = input[3].toCharArray();
                    for (int j = 0; j < 5; j++) {
                        currentSegment += currentSegmentArray[i + j];
                    }
                    
                    if (currentSegment.equalsIgnoreCase("x...x")) {
                        equationInString += "0";
                    }
                    else {
                       currentSegment = "";
                        currentSegmentArray = input[5].toCharArray();
                        for (int j = 0; j < 5; j++) {
                            currentSegment += currentSegmentArray[i + j];
                        } 
                        
                        if (currentSegment.equalsIgnoreCase("....x")) {
                            equationInString += "9";
                        }
                        else {
                            equationInString += "8";
                        }
                    }
                }
                else if (currentSegment.equalsIgnoreCase("....x")) {
                    //2, 3, 7
                    currentSegment = "";
                    currentSegmentArray = input[3].toCharArray();
                    for (int j = 0; j < 5; j++) {
                        currentSegment += currentSegmentArray[i + j];
                    }
                    
                    if (currentSegment.equalsIgnoreCase("....x")) {
                        equationInString += "7";
                    }
                    else {
                        currentSegment = "";
                        currentSegmentArray = input[4].toCharArray();
                        for (int j = 0; j < 5; j++) {
                            currentSegment += currentSegmentArray[i + j];
                        }
                        
                        if (currentSegment.equalsIgnoreCase("....x")) {
                            equationInString += "3";
                        }
                        else {
                            equationInString += "2";
                        }
                    }
                }
                else {
                    //5, 6
                    currentSegment = "";
                    currentSegmentArray = input[4].toCharArray();
                    for (int j = 0; j < 5; j++) {
                        currentSegment += currentSegmentArray[i + j];
                    }
                    
                    if (currentSegment.equalsIgnoreCase("x...x")) {
                        equationInString += "6";
                    }
                    else {
                        equationInString += "5";
                    }
                }
            }
        }
        printOutput(equationInString);
    }
    
    private static void printOutput(String equationString) {
        int a, b;
        String[] splitString = equationString.split("\\+");
        a = Integer.parseInt(splitString[0]);
        b = Integer.parseInt(splitString[1]);
        int answer = a + b;
        
        String[] answerString = Integer.toString(answer).split("");
        String[] asciiRows = new String[] {"", "", "", "", "", "", ""};
        
        for (int i = 0; i < answerString.length; i++) {
            for (int j = 1; j <= 7; j++) {
                String asciiPortion = getLine(answerString[i], j);
                if (i != answerString.length - 1) {
                    asciiRows[j - 1] += asciiPortion + ".";
                }
                else {
                    asciiRows[j - 1] += asciiPortion;
                }
            }
        }
        
        for (String line : asciiRows) {
            System.out.println(line);
        }
    }
    
    private static String getLine(String number, int row) {
        String asciiLine = "";
        
        switch(row) {
            case 1:
                switch (number) {
                    case "0":
                    case "2":
                    case "3":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                        asciiLine += "xxxxx";
                        break;
                    case "1":
                        asciiLine += "....x";
                        break;
                    case "4":
                        asciiLine += "x...x";
                        break;
                }
                break;
            case 2: case 3:
                switch (number) {
                    case "0":
                    case "4":
                    case "8":
                    case "9":
                        asciiLine += "x...x";
                        break;
                    case "1":
                    case "2":
                    case "3":
                    case "7":
                        asciiLine += "....x";
                        break;
                    case "5":
                    case "6":
                        asciiLine += "x....";
                        break;
                }
                break;
            case 4:
                switch (number) {
                    case "0":
                        asciiLine += "x...x";
                        break;
                    case "1":
                    case "7":
                        asciiLine += "....x";
                        break;
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "8":
                    case "9":
                        asciiLine += "xxxxx";
                        break;
                }
                break;
            case 5: case 6:
                switch (number) {
                    case "0":
                    case "6":
                    case "8":
                        asciiLine += "x...x";
                        break;
                    case "1":
                    case "3":
                    case "4":
                    case "5":
                    case "7":
                    case "9":
                        asciiLine += "....x";
                        break;
                    case "2":
                        asciiLine += "x....";
                        break;
                }
                break;
            case 7:
                switch (number) {
                    case "0":
                    case "2":
                    case "3":
                    case "5":
                    case "6":
                    case "8":
                    case "9":
                        asciiLine += "xxxxx";
                        break;
                    case "1":
                    case "4":
                    case "7":
                        asciiLine += "....x";
                        break;
                }
                break;
        }
        
        return asciiLine;
    }
}

