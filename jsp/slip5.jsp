<html>
<body>

<%
int num = Integer.parseInt(request.getParameter("num"));

int last = num % 10;

while(num >= 10)
{
    num = num / 10;
}

int first = num;

int sum = first + last;
%>

<font color="red" size="5">
Sum of First and Last Digit = <%= sum %>
</font>

</body>
</html>