package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static ProductDao productDao;
	static {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> getAllProduct(String name) {
		return productDao.getAllProduct(name);
	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}
	
	@Override
	public boolean addProduct(String name, String price, String category) {
		return productDao.addProduct(name, price, category);
	}
	
	@Override
	public boolean updateProduct(String id, String name, String price, String category) {
		return productDao.updateProduct(id, name, price, category);
	}
	
	@Override
	public boolean deleteProduct(String id) {
		return productDao.deleteProduct(id);
	}
}
