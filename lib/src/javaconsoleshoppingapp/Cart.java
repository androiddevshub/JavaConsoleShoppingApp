/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsoleshoppingapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author shubham
 */
public class Cart {
    
    List<CartItem>  cartItems = new ArrayList<>();
    Integer quantity; 
    
    public void addItemToCartByIID(Integer iid, Integer quanity) {
        this.quantity = quantity;
        Item item = getItemByItemID(iid);
        addToCart(item, quanity);
    }

    private Item getItemByItemID(Integer iid) {
        Item item = null;
        List<Item> items = new InitItem().getItems();
        for (Item _item: items) {
            if (Objects.equals(iid, _item.getId())) {
                item = _item;
                break;
            }
        }
        return item;
    }
    
    public boolean getStockByItemID(Integer i_stock) {
        List<Item> items = new InitItem().getItems();
        for (Item _item: items) {
            if (!(_item.getStock() >= i_stock)) {
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
    
    public boolean cartEmpty(){
        if(cartItems.isEmpty()){
            return true;
        }
        return false;
    }

    private void addToCart(Item item, Integer quanity) {
        cartItems.add(new CartItem(item, quanity));
    }

//    public void removeItemByPID(Integer iid) {
//        Item _item = getItemByItemID(iid);
//        cartItems.remove(_item);
//    }

    void printCartItems() {
        System.out.println("ItemId\t\tItemPriceItem\tQuantity\tItemName");
        for (CartItem cartItem: cartItems) {
            System.out.println(cartItem.getItem().getId()+ "\t\t"
                    + cartItem.getItem().getPrice()*cartItem.getQuantity() + "\t\t"
                    + cartItem.getQuantity() + "\t\t"+ cartItem.getItem().getName() + "\n");
        }
    }
    
    public Integer cartTotal(){
        Integer total = 0;
        for (CartItem cartItem: cartItems) {
            total += cartItem.getItem().getPrice() * cartItem.getQuantity();
        }
        return total;
    }
}
