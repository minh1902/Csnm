package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.UserDao;
import jdbc.DBConnection;

public class UserDaoImpl implements UserDao{
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	@Override
	public String checkLogin(String userName, String password) {
		String sql = "SELECT username FROM user WHERE username = ? AND password =?";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, userName);
			preStatement.setString(2, password);
			rs = preStatement.executeQuery();
			while(rs.next()) {
				return rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
}
