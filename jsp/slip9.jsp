<!-- page1.jsp -->


<%
int item1 = Integer.parseInt(request.getParameter("item1"));
session.setAttribute("p1", item1);
response.sendRedirect("page2.jsp");
%>

<!-- page2.jsp -->
<%
int item2 = Integer.parseInt(request.getParameter("item2"));
session.setAttribute("p2", item2);
response.sendRedirect("bill.jsp");
%>

<!-- bill.jsp -->
<%
int p1 = (Integer)session.getAttribute("p1");
int p2 = (Integer)session.getAttribute("p2");

int total = p1 + p2;

out.println("Page1 Total: " + p1 + "<br>");
out.println("Page2 Total: " + p2 + "<br>");
out.println("Grand Total: " + total);
%>