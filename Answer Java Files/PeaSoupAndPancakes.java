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
        //first line = no of restaurants, 1 menu per restaurant
        
        //number of menu items
        //restaurant name
        //menu items 
        
        //If one restaurant has 'pea soup' and 'pancakes', output first 
        //restaurant name with the items
        //If none, output "Anywhere is fine I guess"
        
        Scanner scan = new Scanner(System.in);
        ArrayList<Restaurant> restaurantList = new ArrayList<>();
        int numberOfShops = Integer.parseInt(scan.nextLine());
        
        for (int i = 0; i < numberOfShops; i++) {
            Restaurant newRestaurant = new Restaurant(Integer.parseInt(scan.nextLine()));
            newRestaurant.setName(scan.nextLine());
            
            for (int j = 0; j < newRestaurant.getNumberOfItems(); j++) {
                newRestaurant.setMenuItem(j, scan.nextLine());
            }
            
            restaurantList.add(newRestaurant);
        }
        
        boolean availableSomewhere = false;
        String nameOfRestaurant = "";
        for (Restaurant rest : restaurantList) {
            if (availableSomewhere == false) {
                if (rest.hasPeasAndPancakes()) {
                    availableSomewhere = true;
                    nameOfRestaurant = rest.getName();
                }
            }
        }
        
        if (availableSomewhere == true) {
            System.out.println(nameOfRestaurant);
        }
        else {
            System.out.println("Anywhere is fine I guess");
        }
    }
    
    public static class Restaurant {
        int numberOfMenuItems;
        String nameOfRestaurant;
        String[] menuItems;
        
        public Restaurant(int numberOfItems) {
            this.numberOfMenuItems = numberOfItems;
            menuItems = new String[numberOfItems];
        }
        
        public void setName(String name) {
            this.nameOfRestaurant = name;
        }
        public String getName() {
            return this.nameOfRestaurant;
        }
        
        public void setMenuItem(int index, String itemName) {
            menuItems[index] = itemName;
        }
        public String getMenuItem(int index) {
            return menuItems[index];
        }
        public int getNumberOfItems() {
            return menuItems.length;
        }
        
        public boolean hasPeasAndPancakes() {
            boolean hasPeaSoup = false;
            boolean hasPancakes = false;
            
            for (String item : menuItems) {
                if (item.equalsIgnoreCase("pea soup")) {
                    hasPeaSoup = true;
                }
                else if (item.equalsIgnoreCase("pancakes")) {
                    hasPancakes = true;
                }
            }
            
            if (hasPeaSoup == true && hasPancakes == true) {
                return true;
            }
            else {
                return false;
            }
        }
        
        
    }
}

