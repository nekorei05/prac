import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class slip26 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String hobby = req.getParameter("hobby");
        boolean exists = false;
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie c: cookies) {
                if(c.getName().equals(hobby)) {
                    exists = true;
                }
            }
        }
        if(!exists) {
            Cookie c = new Cookie(hobby, "selected");
            c.setMaxAge(60*60*24);
            res.addCookie(c);
        }
        
        out.println("<h2>Your hobbies have been saved.</h2>");
    }
}