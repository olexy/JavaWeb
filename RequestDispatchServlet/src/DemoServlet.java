import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	      
	    ServletConfig config=getServletConfig();  
	    String driver=config.getInitParameter("driver");  
	    out.print("Driver is: "+driver); 
	    String url=config.getInitParameter("url");  
	    out.print("Driver is: "+url);  
	    String username=config.getInitParameter("username");  
	    out.print("Driver is: "+username);  
	    String password=config.getInitParameter("password");  
	    out.print("Driver is: "+password);  
	    out.close();  
	}

}
