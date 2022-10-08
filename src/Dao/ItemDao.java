/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Category;
import Model.Item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amin.
 */
public class ItemDao {

    private ArrayList<Item> items;

    public ItemDao() {
        items = new ArrayList();
        String path = "C:\\Users\\Amin\\SuperMart\\src\\Items.txt";
        String line = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(", ");
                Item item = new Item();
                item.setId(Integer.parseInt(values[0]));
                item.setName(values[1]);
                item.setPrice(Double.parseDouble(values[2]));
                item.setCategoryId(Integer.parseInt(values[3]));
                item.setQuantity(1);
                this.items.add(item);
            }
        } catch (IOException e) {
            System.out.println("File Not Found!");
        }
    }

    public ArrayList getItemsByCategoryid(int category) {

        ArrayList<Item> item1 = new ArrayList();
        Item it = new Item();
        it.setCategoryId(category);

        for (Item item : this.items) {
            if (item.equals(it)) {item1.add(item);}
        }
        return item1;
    }
    
    public Item getItemByname(String name){
        Item it = new Item();
        for (Item item : this.items){
            if (item.getName().equalsIgnoreCase(name)){
                it.setName(item.getName());
                it.setPrice(item.getPrice());
                it.setQuantity(1);
            }
        }
        return it;
    }
}
