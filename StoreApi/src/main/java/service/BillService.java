package service;

import java.util.List;

import model.ProductDetail;

public interface BillService {
	boolean insertBill(Double total, String date);
	boolean insertProductDetail(List<ProductDetail> lists);
}
