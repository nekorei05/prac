<!-- 
teacherForm.jsp -->

<form method="post" action="teacher.jsp">
    TID: <input type="text" name="tid" required><br>
    Name: <input type="text" name="tname" required><br>
    Salary: <input type="number" name="salary" required><br>
    <input type="submit" value="Add Teacher">
</form>


<!-- teacher.jsp -->
 <%@ page import="java.util.*" %>
<%
List<Map<String,String>> teachers = (List<Map<String,String>>) application.getAttribute("teachers");
if(teachers == null) {
    teachers = new ArrayList<>();
    application.setAttribute("teachers", teachers);
}

String tid = request.getParameter("tid");
String tname = request.getParameter("tname");
String salary = request.getParameter("salary");

if(tid != null && tname != null && salary != null){
    Map<String,String> t = new HashMap<>();
    t.put("tid", tid);
    t.put("tname", tname);
    t.put("salary", salary);
    teachers.add(t);
}

%>
<h2>Teacher Details</h2>
<table border="1">
    <tr><th>TID</th><th>Name</th><th>Salary</th></tr>
<%
for(Map<String,String> t : teachers){
%>
<tr>
    <td><%= t.get("tid") %></td>
    <td><%= t.get("tname") %></td>
    <td><%= t.get("salary") %></td>
</tr>
<% } %>
</table>
<a href="teacherForm.jsp">Add Another Teacher</a>