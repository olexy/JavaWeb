import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
									throws ServletException, IOException 
	{
		int sid  = Integer.parseInt(request.getParameter("sid"));
		String sfname  = request.getParameter("sfname");
		String slname  = request.getParameter("slname");
		String sdob  = request.getParameter("sdob");
		String saddress  = request.getParameter("saddress");
		String scity  = request.getParameter("scity");
		
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
				String sqlst = "insert into student values(?,?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(sqlst);
				
				pst.setInt(1, sid);
				pst.setString(2, sfname);
				pst.setString(3, slname);
				Date d = Date.valueOf(sdob); //yyyy-mm-dd
				pst.setDate(4, d);
				pst.setString(5, saddress);
				pst.setString(6, scity);
				pst.executeUpdate();
				pw.println(sfname + " " + slname + " Successfully Saved!");
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
