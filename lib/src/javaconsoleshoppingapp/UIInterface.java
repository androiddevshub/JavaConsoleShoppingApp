/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsoleshoppingapp;

/**
 *
 * @author shubham
 */
import java.util.List;
import java.util.Scanner;

public class UIInterface {

    Cart cart = new Cart();
    Item item = new Item();
    InitItem initItem = new InitItem();
    List<Item> items = new InitItem().getItems();
    private int ch = 0;
    
    public UIInterface () {
        menu();
    }

    public void startScreen () {
        System.out.println("1. Display all Items");
        System.out.println("2. Display Cart");
        System.out.println("3. Place an Order");
        System.out.println("0. Exit");
    }

    public void cartitemMenu() {
        System.out.println("\n1. Add to Cart");
        System.out.println("0. Exit");
    }

    public void menu () {
        do {
            startScreen();
            System.out.println("Enter choice");
            getUserInputInt();

            switch (ch) {
                case 1:
                    displayAllItems();
                    cartitemMenu();
                     System.out.println("Enter choice");
                    getUserInputInt();
                    innerChoice1();
                    break;
                case 2:
                    if(!cart.cartEmpty()){
                        System.out.println("\nCart Items\n");
                        showCart();
                    }else{
                        System.out.println("\nCart is empty.\n");
                    }
                    break;
                case 3:
                    placeOrder();
                    System.out.println("\n-----------------Thank you, Visit again--------------------\n");
                    break;    
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entered wrong choice\n");
                    break;
            }
        } while (ch != 0);
    }

    private void innerChoice1() {
        switch (ch) {
            case 1:
                System.out.println("Enter item id:");
                Scanner in = new Scanner(System.in);
                Integer itemId = Integer.parseInt(in.nextLine());
                if (initItem.checkItem(itemId)){
                    System.out.println("Enter quantity");
                    Integer quant = Integer.parseInt(in.nextLine());
                    if (cart.getStockByItemID(quant)){  
                       addProductToCart(itemId, quant);
                    }else {
                        System.out.println("\nItem out of stock\n");
                    }
                }else {
                    System.out.println("Item Id not found");
                }
                break;
            default:
                System.out.println("Entered wrong choice\n");
                break;
        }
    }

    private int getUserInputInt() throws NumberFormatException {
        Scanner in = new Scanner (System.in);
        ch = Integer.parseInt(in.nextLine());
        return ch;
    }

    private void displayAllItems() {
        System.out.println("Id\t\tPrice\t\tStock\t\tName");
        for (Item prod: items) {
            System.out.println(
                    prod.getId() + "\t\t" +
                            prod.getPrice() + "\t\t" +
                            prod.getStock() + "\t\t" +
                            prod.getName()
            );
        }
    }

    private void addProductToCart(Integer iid, Integer quantity) {
        cart.addItemToCartByIID(iid, quantity);
    }

    private void showCart() {
        cart.printCartItems();
    }
   
//    private void removeProductFromCart() {
//        Integer iid = getUserInputInt();
//        cart.removeItemByPID(iid);
//    }

    private void placeOrder(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name");
        String userName = in.nextLine();
        System.out.println("Please enter your address");
        String userAdd = in.nextLine();
        System.out.println("------------------------------------------------------------");
        System.out.println("\t\t\tInvoice\n");
        cart.printCartItems();
        System.out.println("\nTotal : "+ cart.cartTotal());
        System.out.println("\nName : "+ userName);
        System.out.println("Address : "+ userAdd);
    }
}

