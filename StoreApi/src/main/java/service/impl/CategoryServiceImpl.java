package service.impl;

import java.util.List;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private static CategoryDao categoryDao;
	static {
		categoryDao = new CategoryDaoImpl();
	}
	@Override
	public List<String> getAllCategory() {
		return categoryDao.getAllCategory();
	}
}
