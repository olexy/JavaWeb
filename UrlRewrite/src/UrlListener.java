

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UrlListener")
public class UrlListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String sfname  = request.getParameter("firstname");
		String slname  = request.getParameter("lastname");
		String scity  = request.getParameter("city");
		
		pw.println("Student Name and City are");
		pw.print("<br>");
		pw.print(sfname);
		pw.print("<br>");
		pw.print(slname);
		pw.print("<br>");
		pw.print(scity);
		
	}

}
