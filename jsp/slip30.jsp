<html>
<body>

<%
String str = request.getParameter("text");

String rev = new StringBuffer(str).reverse().toString();

out.println("Reverse String: " + rev);
%>

</body>
</html>