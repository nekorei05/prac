import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip6 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        int count = 1;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }
        Cookie visitCookie = new Cookie("visitCount", Integer.toString(count));
        visitCookie.setMaxAge(60*60*24); // 1 day
        res.addCookie(visitCookie);
        
        if (count == 1)
            out.println("Welcome! This is your first visit.");
        else
            out.println("You have visited " + count + " times.");
    }
}