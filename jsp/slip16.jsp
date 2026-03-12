<%
String user = request.getParameter("username");
String pass = request.getParameter("password");

if(user.equals(pass))
{
    response.sendRedirect("Login.html");
}
else
{
    response.sendRedirect("Error.html");
}
%>