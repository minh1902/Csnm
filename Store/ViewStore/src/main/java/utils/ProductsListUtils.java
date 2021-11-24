/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class ProductsListUtils {
    public static Map<String, Integer> productsList;
    static {
        productsList = new HashMap<>();
    }
    private ProductsListUtils(){
        
    }
    
    public static Map<String, Integer> getIds(){
        return productsList;
    }
}
