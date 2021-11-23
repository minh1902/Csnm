package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	List<Product> getAllProduct(String name);
	List<Product> getProductsByCategory(String category);
	boolean addProduct(String name, String price, String category);
	boolean updateProduct(String id, String name, String price, String category);
	boolean deleteProduct(String id);
}
