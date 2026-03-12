<html>
<body>

<%
String ano = request.getParameter("ano");
String type = request.getParameter("type");
String bal = request.getParameter("bal");
%>

<table border="1">
<tr>
<th>Account No</th>
<th>Type</th>
<th>Balance</th>
</tr>

<tr>
<td><%= ano %></td>
<td><%= type %></td>
<td><%= bal %></td>
</tr>

</table>

</body>
</html>