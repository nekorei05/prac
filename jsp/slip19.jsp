<%@ page import="java.util.*" %>

<%
String name = request.getParameter("name");

Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);

if(hour < 12)
    out.println("Good Morning " + name);
else if(hour < 16)
    out.println("Good Afternoon " + name);
else
    out.println("Good Evening " + name);
%>