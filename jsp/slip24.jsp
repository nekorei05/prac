<html>
<body>

<%
String num = request.getParameter("num");

String[] words = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

for(int i=0;i<num.length();i++)
{
    int digit = num.charAt(i)-'0';
%>

<font color="red">
<%= words[digit] %>
</font>

<%
}
%>

</body>
</html>