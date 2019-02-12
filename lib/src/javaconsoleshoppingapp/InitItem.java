/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsoleshoppingapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shubham
 */
public class InitItem {
    
    private final List<Item> items = new ArrayList<>();
    Integer [] id = {5, 21 , 12, 45, 9, 17, 33, 34};
    String [] name = {"Juice", "Milk", "Chocalate", "Coke", "Maggie", "Rusk", "Chips", "Cookies", };
    Integer [] price = {20, 26, 100, 60, 40, 20, 20, 50};
    Integer [] stock = {10, 6, 4, 3, 0, 13, 2, 7};
    Integer quantity;

    Integer itemId;
    
    public InitItem() {
        this.initStoreItems();
    }

    public List<Item> getItems() {
        return items;
    }

    public void initStoreItems() {
        for (int i=0; i < id.length; i++) {
            this.items.add(new Item(id[i], name[i], price[i], stock[i]));
        }
    }
    
    public boolean checkItem(Integer i_id){
       this.itemId = i_id;
       for (Item item: items) {
           if(item.getId().equals(i_id)){
               return true;
           } 
        }
       return false;
    }
}
