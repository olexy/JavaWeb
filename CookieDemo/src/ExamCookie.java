

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ExamCookie
 */
@WebServlet("/ExamCookie")
public class ExamCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int sid  = Integer.parseInt(request.getParameter("sid"));
		String sfname  = request.getParameter("sfname");
		String slname  = request.getParameter("slname");
		String sdob  = request.getParameter("sdob");
		String saddress  = request.getParameter("saddress");
		String scity  = request.getParameter("scity");
		
		pw.println("Student Details are");
		pw.println(sid);
		pw.println(sfname);
		pw.println(slname);
		pw.println(sdob);
		pw.println(saddress);
		pw.println(scity);
		
		Cookie c1 = new Cookie("sfname", sfname);
		Cookie c2 = new Cookie("slname", slname);
		Cookie c3 = new Cookie("scity", scity);
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		
		pw.println("<a href =/CookieDemo/AcceptCookie>Show</a>");
	}

}
