package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class UserApi extends HttpServlet{
	private static UserService userService;
	static {
		userService = new UserServiceImpl();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String result = userService.checkLogin(username, password);
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", result);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(map));
		out.flush();
	}
}
