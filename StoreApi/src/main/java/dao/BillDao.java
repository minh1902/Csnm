package dao;

import java.util.List;

import model.ProductDetail;

public interface BillDao {
	boolean insertBill(Double total, String date);
	boolean insertProductDetail(List<ProductDetail> lists);
}
