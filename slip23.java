import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip23 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop", "root", "password");
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, uname);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                out.println("Login successful. Welcome, " + uname);
            else
                out.println("Invalid username or password.");
            
            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}