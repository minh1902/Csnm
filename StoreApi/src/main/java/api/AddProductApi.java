package api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ProductService;
import service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/add"})
public class AddProductApi extends HttpServlet{
	private static ProductService productService;
	static {
		productService = new ProductServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String category = req.getParameter("category");
		System.out.println(name +" - " + category);
		
		boolean result = productService.addProduct(name, price, category);
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
		
	}
}
