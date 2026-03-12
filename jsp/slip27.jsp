<html>
<body>

<%
String tid = request.getParameter("tid");
String name = request.getParameter("name");
String desg = request.getParameter("desg");
String subject = request.getParameter("subject");
String qual = request.getParameter("qual");
%>

Teacher ID : <%= tid %> <br>
Name : <%= name %> <br>
Designation : <%= desg %> <br>
Subject : <%= subject %> <br>
Qualification : <%= qual %>

</body>
</html>