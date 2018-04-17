package servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "forwardOrRedirect", 
			urlPatterns = {"/fr", "/fr/*"}, 
			loadOnStartup = 1)
public class ForwardOrRedirectServlet extends HttpServlet {
	
	final static String FORWARD="forward";
	final static String REDIRECT="redirect";
	
	public ForwardOrRedirectServlet() {
		/**
		 * 因为在@WebServlet注解里配置了loadOnStartup=1
		 * HelloServlet中没有配置，则在第一次访问时再加载
		 */
		System.out.println("servlet load on startup");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if(type!=null) {
			if(type.equals(FORWARD)) {
				//指向HelloServlet,地址栏不改变
				RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
				dispatcher.forward(request, response);
			}else if(type.equals(REDIRECT)) {
				//地址栏改变，注意一定要加上http
				response.sendRedirect("http://www.baidu.com");
			}else {
				response.getWriter().write("the type is wrong");
			}
		}else {
			response.getWriter().write("missing argument type");
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	/*@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(msg);
	}*/
}
