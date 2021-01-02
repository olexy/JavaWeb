import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int eno  = Integer.parseInt(request.getParameter("eno"));
		String ename  = request.getParameter("ename");
		float esal  = Float.parseFloat(request.getParameter("esal"));
		
		PrintWriter pw = response.getWriter();
		
		//Register Driver
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Create Connection
		Connection con;
		try {
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			String sqlst = "insert into employee values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sqlst);
			
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setFloat(3, esal);
			
			pst.executeUpdate();
			pw.println(ename+" Successfully Saved!");
			} catch (SQLException e) {		
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
