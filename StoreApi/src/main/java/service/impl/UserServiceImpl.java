package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService{
	private static UserDao userDao;
	static {
		userDao = new UserDaoImpl();
	}
	@Override
	public String checkLogin(String userName, String password) {
		return userDao.checkLogin(userName, password);
	}
}
