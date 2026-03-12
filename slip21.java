import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip21 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String seatNo = req.getParameter("SeatNo");
        String name = req.getParameter("Stud_Name");
        String cls = req.getParameter("Class");
        int total = Integer.parseInt(req.getParameter("Total_Marks"));
        double percent = total; // assuming out of 100
        String grade = (percent >= 90) ? "A" : (percent >= 75) ? "B" : (percent >= 60) ? "C" : "D";
        
        out.println("<h2>Student Details</h2>");
        out.println("Seat No: " + seatNo + "<br>");
        out.println("Name: " + name + "<br>");
        out.println("Class: " + cls + "<br>");
        out.println("Total Marks: " + total + "<br>");
        out.println("Percentage: " + percent + "%<br>");
        out.println("Grade: " + grade + "<br>");
    }
}