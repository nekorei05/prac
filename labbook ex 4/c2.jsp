<!-- login.jsp -->
<form method="post" action="login.jsp">
    Username: <input type="text" name="username" required>
    <input type="submit" value="Login">
</form>

<%
String username = request.getParameter("username");
if(username != null){
    session.setAttribute("username", username);
    session.setAttribute("total", 0);
    response.sendRedirect("books.jsp");
}
%>


<!-- books.jsp -->
<%
String user = (String) session.getAttribute("username");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<h2>Welcome, <%=user%></h2>
<form method="post" action="books.jsp">
    <input type="checkbox" name="book" value="Book1:100"> Book1 - $100<br>
    <input type="checkbox" name="book" value="Book2:200"> Book2 - $200<br>
    <input type="checkbox" name="book" value="Book3:150"> Book3 - $150<br><br>
    <input type="submit" value="Add to Cart">
</form>

<%
int total = (Integer) session.getAttribute("total");
String[] selectedBooks = request.getParameterValues("book");
if(selectedBooks != null){
    for(String b : selectedBooks){
        String[] parts = b.split(":");
        total += Integer.parseInt(parts[1]);
    }
    session.setAttribute("total", total);
}
out.println("<h3>Current Page Total: $" + total + "</h3>");
%>

<a href="checkout.jsp">Checkout</a>


<!-- checkout.jsp -->

<%
String user = (String) session.getAttribute("username");
if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
int total = (Integer) session.getAttribute("total");
out.println("<h2>Thank you, "+user+"</h2>");
out.println("<h3>Your Total Bill: $" + total + "</h3>");
session.invalidate();
%>