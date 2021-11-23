package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;

import model.ProductDetail;
import service.BillService;
import service.impl.BillServiceImpl;

@WebServlet(urlPatterns = {"/add-bill"})
public class BillApi extends HttpServlet{
	private static BillService billService;
	static {
		billService = new BillServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double total = Double.valueOf(req.getParameter("total"));
		String date = req.getParameter("date");
		boolean check = billService.insertBill(total, date);
		String listsStr = req.getParameter("lists");
		System.out.println(listsStr);
		Gson gson = new Gson();
		JSONArray array = new JSONArray(listsStr);
		List<ProductDetail> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
        	lists.add(gson.fromJson(array.get(i).toString(), ProductDetail.class));
        }
        check = billService.insertProductDetail(lists);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(check));
		out.flush();
	}
}
