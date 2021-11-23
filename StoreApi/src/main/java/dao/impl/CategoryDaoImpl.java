package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.SqlUtils;
import dao.CategoryDao;
import jdbc.DBConnection;

public class CategoryDaoImpl implements CategoryDao{
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	public List<String> getAllCategory() {
		String sql = "SELECT name FROM category";
		List<String> result = new ArrayList<String>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
}
