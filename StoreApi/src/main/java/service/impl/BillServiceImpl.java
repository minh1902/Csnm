package service.impl;

import java.util.List;

import dao.BillDao;
import dao.impl.BillDaoImpl;
import model.ProductDetail;
import service.BillService;

public class BillServiceImpl implements BillService{
	private static BillDao billDao;
	static {
		billDao = new BillDaoImpl();
	}
	
	@Override
	public boolean insertBill(Double total, String date) {
		return billDao.insertBill(total, date);
	}
	
	@Override
	public boolean insertProductDetail(List<ProductDetail> lists) {
		return billDao.insertProductDetail(lists);
	}
}
