import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip29 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(10*60); // 10 minutes
        out.println("Session timeout interval set to 10 minutes.");
    }
}