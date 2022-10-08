/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Category;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amin.
 */
public class CategoryDao {

    private ArrayList<Category> categories;

    public CategoryDao() {
        
        categories = new ArrayList();
        String path = "C:\\Users\\Amin\\SuperMart\\src\\Category.txt";
        String line = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Category category = new Category();
                category.setId(Integer.parseInt(values[0]));
                category.setName(values[1]);
                this.categories.add(category);
            }
        } catch (IOException e) {
            System.out.println("File Not Found!");
        }
    }

    public ArrayList getCategories() {
        return this.categories;
    }
    
    public int getCategoryByName(String name){
        int id = 0;
        for(Category c : this.categories){
            if(c.getName().equalsIgnoreCase(name)){
                id = c.getId();
            }
        }
        return id;
    }
}
