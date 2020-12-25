import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<a href=/EmpStu/EmployeeForm.html>Employee Form </a>");
		pw.println("<br><br>");
		pw.println("<a href=/EmpStu/StudentForm.html>Student Form </a>");
	}
		
}
