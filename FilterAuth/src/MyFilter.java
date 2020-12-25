

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;

public class MyFilter implements Filter {
	

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		 String n=request.getParameter("name");  
		 String p=request.getParameter("password"); 
		 
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
					Statement stmt = con.createStatement();
					String sqlst = "select * from app_users where username='"+n+"' and password='"+p+"'";
					ResultSet rs = stmt.executeQuery(sqlst);
					
					if(rs.next()) {
						chain.doFilter(request, response); // pass the request along the filter chain
					}else
						out.print("username or password error!");  
						RequestDispatcher rd = request.getRequestDispatcher("index.html");  
						rd.include(request, response); 					
				} catch (SQLException e) {		
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			out.close();
			
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}



}
