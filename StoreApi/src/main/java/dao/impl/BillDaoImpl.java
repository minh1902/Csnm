package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import Utils.SqlUtils;
import dao.BillDao;
import jdbc.DBConnection;
import model.ProductDetail;

public class BillDaoImpl implements BillDao	{
	private static Connection conn;
	private static Statement st;
	private static PreparedStatement ps;
	private static ResultSet rs;

	static {
		conn = DBConnection.getConnection();
	}
	@Override
	public boolean insertBill(Double total, String date) {
		String sql = "INSERT INTO `store`.`bill` (`total`, `date`) VALUES (?, ?);\r\n";
		try {
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, total);
			ps.setString(2, date);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertProductDetail(List<ProductDetail> lists) {
		String sql = "SELECT MAX(id) id FROM bill";
		Integer idBill = -1;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				idBill = rs.getInt("id");
			}
			System.out.println("maxId:" +idBill);
		} catch (SQLException e) {
			System.out.println("getMax:" + e.getMessage());
			return false;
		} finally {
			SqlUtils.close(rs, st);
		}
		
		for (int i = 0; i < lists.size(); i++) {
			String sqlInsert = "INSERT INTO `store`.`productdetail` (`productId`, `billId`, `count`)\r\n"
					+ "VALUES (?, ?, ?);";
			try {
				ps = conn.prepareStatement(sqlInsert);
				ps.setInt(1, lists.get(i).getproductId());
				ps.setInt(2, idBill);
				ps.setInt(3, lists.get(i).getcount());
				ps.execute();
			} catch (SQLException e) {
				System.out.println("inssert item:" + e.getMessage());
				return false;
			} finally {
				SqlUtils.close(rs, ps);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new BillDaoImpl().insertBill(10.0, "2015-12-25 15:30:00"));
		System.out.println(new BillDaoImpl().insertProductDetail(Arrays.asList(
														new ProductDetail(1,2),new ProductDetail(2,3)
																
				)));
	}
	
	
}
