<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head><title>Greeting</title></head>
<body>
    <form method="post">
        Enter your name: <input type="text" name="username" required>
        <input type="submit" value="Greet">
    </form>

<%
String username = request.getParameter("username");
if (username != null) {
    Calendar cal = Calendar.getInstance();
    int hour = cal.get(Calendar.HOUR_OF_DAY);
    String greeting;
    if(hour < 12) greeting = "Good Morning";
    else if(hour < 16) greeting = "Good Afternoon";
    else greeting = "Good Evening";

    out.println("<h2>" + greeting + ", " + username + "!</h2>");
}
%>
</body>
</html>