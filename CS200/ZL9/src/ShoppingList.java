///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Shopping List Maker
// Course:          Comp Sci 200, Term 1
//
// Author:          August Bambenek
// Email:           abambenek@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingList {


    /**
     * This method will take ArrayLists representing the shopping list and calculate how much you need to pay.
     * 
     * @param name Item names in your shopping cart
     * @param price The price for each item in ArrayList name
     * @param quantity How many items bought.
     * 
     * @return integer that has the payment, or -1 if any parameter is null.
     */
    public static int calculatePayment(ArrayList<String> name, ArrayList<Integer> price, ArrayList<Integer> quantity) {
        if (name == null || price == null || quantity == null) {
            return -1;
        }
        int priceTotal = 0;
        for (int i = 0; i < name.size(); ++i) {
            priceTotal += price.get(i) * quantity.get(i);
        }
        return priceTotal;
   }
    /**
     * This method will delete the item_name and corresponding price, quantity from the ArrayLists. If any Arraylist
     * parameters are null it returns without changes.
     * 
     * @param item_name name of the item
    * @param name Item names in your shopping cart
     * @param price The price for each item in ArrayList name
     * @param quantity How many items bought.
     */
    public static void deleteItemFromShoppingList(String item_name, ArrayList<String> name, ArrayList<Integer> price, ArrayList<Integer> quantity) {
        if (name == null || price == null || quantity == null) {
            return;
        }
        for (int i = 0; i <= name.size(); ++i) {
            if (item_name.equals(name.get(i))) {
                name.remove(i);
                price.remove(i);
                quantity.remove(i);
                return;
            }
        }
    }
    /**
     * This method will update the quantity for a given item_name and item_price. If any ArrayList parameter
     * is null this will return without changes.
     * 
     * @param item_name name of the item
    * @param item_price price of the item
    * @param item_quantity quantity of the item
    * @param name Item names in your shopping cart
     * @param price The price for each item in ArrayList name
     * @param quantity How many items bought.
     */
    public static void updateShoppingList(String item_name, int item_price, int item_quantity, ArrayList<String> name, 
       ArrayList<Integer> price, ArrayList<Integer> quantity) {
        if (name == null || price == null || quantity == null) {
            return;
        }
        for (int i = 0; i < name.size(); ++i) {
            if (item_name.equals(name.get(i))) {
                if (item_price == price.get(i)) {
                    quantity.set(i, item_quantity);
                }
            }
        }
    }
    
    /**
     * test for calculatePayment()
     * @param items
     * @param price
     * @param quantity
     */
    public static void testCalculatePayment(ArrayList<String> name, ArrayList<Integer> price, ArrayList<Integer> quantity) {
        boolean error = false;
        int payment = calculatePayment(name, price, quantity);
        if(payment != 32){
           error = true;
           System.out.println("Expected payment : " + 32);
           System.out.println("Actual payment : " + payment);
        }
        if(error){
           System.out.println("testCalculatePayment fail");
        }else{
           System.out.println("testCalculatePayment pass");
           
        }
    }
    
    /**
     * test for deleteItemFromShoppingList()
     */
    public static void testDeleteItemFromShoppingList(String item_name, ArrayList<String> name, 
    ArrayList<Integer> price, ArrayList<Integer> quantity) {
        deleteItemFromShoppingList(item_name, name, price, quantity);
        for (int i = 0; i < name.size(); ++i) {
            if (item_name.equals(name.get(i))) {
                System.out.println("testDeleteItemFromShoppingList fail");
                return;
            }
        }
        System.out.println("testDeleteItemFromShoppingList pass");
    }
    
    /**
     * test for updateShoppingList()
     */
    public static void testUpdateShoppingList(String item_name, int item_price, int item_quantity, ArrayList<String> name, 
    ArrayList<Integer> price, ArrayList<Integer> quantity) {
        updateShoppingList(item_name, item_price, item_quantity, name, price, quantity);
        for (int i = 0; i < name.size(); ++i) {
            if (item_name.equals(name.get(i))) {
                if (item_price == price.get(i)) {
                    if (item_quantity == quantity.get(i)) {
                        System.out.print("testUpdateShoppingList pass");
                        return;
                    }
                }
                if (item_price != price.get(i)) {
                    if (item_quantity != quantity.get(i)) {
                        System.out.print("testUpdateShoppingList pass");
                        return;
                    }
                }
            }
        }
        System.out.println("testUpdateShoppingList fail");
    }
        
    public static void main(String[] args) {
        ArrayList<String> item = new ArrayList<>(Arrays.asList("oreo", "ice-cream", "oatmeal"));
        ArrayList<Integer> price = new ArrayList<>(Arrays.asList(3, 5, 7));
        ArrayList<Integer> quantity = new ArrayList<>(Arrays.asList(2, 1, 3));
        testCalculatePayment(item, price, quantity);
        testDeleteItemFromShoppingList("oatmeal", item, price, quantity);
        testUpdateShoppingList("oreo", 3, 15, item, price, quantity);

    }
}
