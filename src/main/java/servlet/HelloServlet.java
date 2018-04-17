package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "hello", 
			urlPatterns = {"/hello", "/hello/*"}
			)
public class HelloServlet extends HttpServlet{

	public HelloServlet() {
		System.out.println("load HelloServlet");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().write("hello world:"+request.getParameter("type"));
	}
}
