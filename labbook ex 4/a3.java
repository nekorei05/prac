import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class a3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Patient Details</h2>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdb","root","password");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM patient");

            out.println("<table border='1'><tr><th>No</th><th>Name</th><th>Address</th><th>Age</th><th>Disease</th></tr>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt("PatientNo")+"</td>");
                out.println("<td>"+rs.getString("PatientName")+"</td>");
                out.println("<td>"+rs.getString("PatientAddress")+"</td>");
                out.println("<td>"+rs.getInt("PatientAge")+"</td>");
                out.println("<td>"+rs.getString("PatientDisease")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        } catch(Exception e) {
            out.println("Error: "+e.getMessage());
        }
    }
}