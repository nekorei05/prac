import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class a2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String subject = request.getParameter("subject");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        boolean cookieExists = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("subject") && c.getValue().equals(subject)) {
                    cookieExists = true;
                    break;
                }
            }
        }

        if (!cookieExists) {
            Cookie cookie = new Cookie("subject", subject);
            cookie.setMaxAge(60*60*24); // 1 day
            response.addCookie(cookie);
            out.println("<h3>Subject '" + subject + "' saved in cookie!</h3>");
        } else {
            out.println("<h3>Subject already selected. No duplicate cookie!</h3>");
        }
    }
}


// <!DOCTYPE html>
// <html>
// <head>
//     <title>Select Subject</title>
// </head>
// <body>
//     <h2>Select Your Subject</h2>
//     <form action="SubjectServlet" method="post">
//         <input type="radio" name="subject" value="Maths"> Maths<br>
//         <input type="radio" name="subject" value="Physics"> Physics<br>
//         <input type="radio" name="subject" value="Chemistry"> Chemistry<br>
//         <input type="radio" name="subject" value="Biology"> Biology<br><br>
//         <input type="submit" value="Submit">
//         <input type="reset" value="Reset">
//     </form>
// </body>
// </html>