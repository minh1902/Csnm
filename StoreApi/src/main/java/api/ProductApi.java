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

import com.google.gson.Gson;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/product"})
public class ProductApi extends HttpServlet{
	private static ProductService productService;
	static {
		productService = new ProductServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Product> result = new ArrayList<>();
		String name = "";
		if(req.getParameter("name") != null) {
			name = req.getParameter("name");
			result = productService.getAllProduct(name);
		} else if(req.getParameter("category") != null) {
			result = productService.getProductsByCategory(req.getParameter("category"));
		}
		
//			result = productService.getAllProduct(name);
		
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
}
