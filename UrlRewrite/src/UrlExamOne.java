

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UrlExamOne")
public class UrlExamOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int sid  = Integer.parseInt(request.getParameter("sid"));
		String sfname  = request.getParameter("sfname");
		String slname  = request.getParameter("slname");
		String sdob  = request.getParameter("sdob");
		String saddress  = request.getParameter("saddress");
		String scity  = request.getParameter("scity");
		
		pw.println("<a href='./UrlListener?firstname="+sfname+"&lastname="+slname+"&city="+scity+"'>Show</a>");
		
		
		
	}

}
