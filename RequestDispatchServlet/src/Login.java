import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
  
@WebServlet("/Login")  
public class Login extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("uname");  
    String p=request.getParameter("psw");  
          
//    if(p.equals("servlet")){  
//        RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
//        rd.forward(request, response);  
//    }  
//    else{  
//        out.print("Sorry UserName or Password Error!");  
//        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
//        rd.include(request, response);  
//                      
//        }
    ServletConfig config=getServletConfig();  
    String driver=config.getInitParameter("driver");  
    out.print("Driver is: "+driver); 
    out.print("<br>");
    String url=config.getInitParameter("url");  
    out.print("Url is: "+url);  
    out.print("<br>");
    String username=config.getInitParameter("username");  
    out.print("Username is: "+username);  
    out.print("<br>");
    String password=config.getInitParameter("password");  
    out.print("Password is: "+password); 
    out.print("<br>");
   	
	//Register Driver
	try {
	Class.forName(driver);
	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Create Connection
	Connection con;
	try {
			con = DriverManager.getConnection
					(url,username,password);
			Statement stmt = con.createStatement();
			String sqlst = "select * from student where sfname='"+n+"' and slname='"+p+"'";
			ResultSet rs = stmt.executeQuery(sqlst);
			
			if(rs.next())
				out.println(n+ " " + p + " Successfully logged in!");
			else
				out.println(" Incorrect username or password");
			
		} catch (SQLException e) {		
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	out.close();
    
    }  
  
}  