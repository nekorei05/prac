<html>
<body>

<%
String email = request.getParameter("email");

if(email.contains("@") && email.contains("."))
{
    out.println("Valid Email ID");
}
else
{
    out.println("Invalid Email ID");
}
%>

</body>
</html>