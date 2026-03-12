import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class a5 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
            out.println("<h3>Welcome! This is your first visit.</h3>");
        } else {
            visitCount += 1;
            out.println("<h3>Welcome back! Visit count: " + visitCount + "</h3>");
        }

        session.setAttribute("visitCount", visitCount);
    }
}