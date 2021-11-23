package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.SqlUtils;
import dao.ProductDao;
import jdbc.DBConnection;
import model.Product;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement preStatement;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	
	@Override
	public List<Product> getAllProduct(String name) {
		List<Product> result = new ArrayList<>();
		String sql = "select id, name, price, categoryId FROM product WHERE name LIKE '%"+ name +"%';";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> result = new ArrayList<>();
		String sql = "select P.id, P.name, P.price, categoryId from product P "
				+ "join category C " +  "on C.id = P.categoryId where C.name LIKE '%" + category + "%' ORDER BY name";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				result.add(transformer());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs, st);
		}
		return result;
	}
	
	@Override
	public boolean addProduct(String name, String price, String category) {
		String sql = "INSERT INTO `store`.`product` (`name`, `price`, `categoryId`) VALUES (?, ?, (SELECT id FROM category WHERE name = ?));\r\n";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, name);
			preStatement.setString(2, price);
			preStatement.setString(3, category);
			preStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(preStatement);
		}
		return false;
	}
	
	@Override
	public boolean updateProduct(String id, String name, String price, String category) {
		String sql = "UPDATE `store`.`product` SET `name` = ?, `price` = ?, categoryId = (SELECT id FROM category WHERE name = ?) WHERE (`id` = ?);\r\n"
				+ "";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, name);
			preStatement.setString(2, price);
			preStatement.setString(3, category);
			preStatement.setString(4, id);
			preStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(preStatement);
		}
		return false;
	}
	
	@Override
	public boolean deleteProduct(String id) {
		String sql = "DELETE FROM `store`.`product` WHERE (`id` = ?);\r\n";
		try {
			preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, id);
			preStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(preStatement);
		}
		return false;
	}
	
	private Product transformer() throws SQLException{
		Product item = new Product();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setPrice(rs.getDouble("price"));
		item.setCategory(rs.getInt("categoryId"));
		return item;
	}
}
