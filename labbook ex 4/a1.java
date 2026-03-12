import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class a1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String custNo = request.getParameter("custNo");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdb", "root", "password");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM customer WHERE custNo=?");
            ps.setString(1, custNo);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.println("<h2>Customer Details</h2>");
                out.println("Customer Number: " + rs.getInt("custNo") + "<br>");
                out.println("Name: " + rs.getString("custName") + "<br>");
                out.println("Address: " + rs.getString("custAddress") + "<br>");
            } else {
                out.println("<h3>Customer not found!</h3>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

// html doc
// <!DOCTYPE html>
// <html>
// <head>
//     <title>Customer Search</title>
// </head>
// <body>
//     <h2>Search Customer</h2>
//     <form action="SearchCustomerServlet" method="get">
//         Enter Customer Number: <input type="text" name="custNo" required>
//         <input type="submit" value="Search">
//     </form>
// </body>
// </html>