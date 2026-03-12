import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip10 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        out.println("<table border='1'><tr><th>ProdCode</th><th>PName</th><th>Price</th></tr>");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shop", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
            while(rs.next()) {
                out.println("<tr><td>" + rs.getString("ProdCode") + "</td>");
                out.println("<td>" + rs.getString("PName") + "</td>");
                out.println("<td>" + rs.getDouble("Price") + "</td></tr>");
            }
            con.close();
        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
        out.println("</table>");
    }
}