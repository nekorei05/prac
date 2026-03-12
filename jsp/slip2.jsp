<%@ page import="java.util.*" %>
<html>
<body>

<%
int num = Integer.parseInt(request.getParameter("num"));
int sum = 0;

for(int i=1;i<=num/2;i++)
{
    if(num%i==0)
        sum=sum+i;
}

if(sum==num)
    out.println(num + " is Perfect Number");
else
    out.println(num + " is Not Perfect Number");
%>

</body>
</html>