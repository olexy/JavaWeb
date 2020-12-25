

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AcceptCookie")
public class AcceptCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Cookie ck[] = request.getCookies();
		pw.println(ck[0].getName()+" : "+ck[0].getValue());
		pw.println(ck[1].getName()+" : "+ck[1].getValue());
		pw.println(ck[2].getName()+" : "+ck[2].getValue());
//		for(Object c:ck) 
//		{
//			System.out.println(c);
//		}
	}

}
