import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip4 extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h3>Client Information</h3>");
        out.println("IP Address: " + req.getRemoteAddr() + "<br>");
        out.println("Browser: " + req.getHeader("User-Agent") + "<br>");

        out.println("<h3>Server Information</h3>");
        out.println("Operating System: " + System.getProperty("os.name") + "<br>");
        out.println("Servlet Name: " + getServletName() + "<br>");
    }
}