<!-- CREATE TABLE questions (
    qid INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(500),
    option1 VARCHAR(200),
    option2 VARCHAR(200),
    option3 VARCHAR(200),
    option4 VARCHAR(200),
    answer VARCHAR(200)
); -->

<%@ page import="java.sql.*,java.util.*,javax.servlet.http.*" %>
<%
    HttpSession session = request.getSession();
    Integer score = (Integer) session.getAttribute("score");
    if(score == null) score = 0;

    Integer qIndex = (Integer) session.getAttribute("qIndex");
    if(qIndex == null) qIndex = 0;

    List<Integer> qIds = (List<Integer>) session.getAttribute("qIds");
    if(qIds == null) {
        qIds = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdb","root","password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT qid FROM questions");
            while(rs.next()) qIds.add(rs.getInt("qid"));
            Collections.shuffle(qIds); // Randomize questions
            session.setAttribute("qIds", qIds);
            con.close();
        } catch(Exception e) { out.println("DB Error: "+e.getMessage()); }
    }

    if(qIndex >= qIds.size()) {
        out.println("<h2>Test completed!</h2>");
        out.println("<h3>Your score is: "+score+"/"+qIds.size()+"</h3>");
        session.invalidate();
        return;
    }

    int currentQid = qIds.get(qIndex);

    String question="", opt1="", opt2="", opt3="", opt4="", answer="";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/yourdb","root","password");
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM questions WHERE qid=?");
        ps.setInt(1, currentQid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            question = rs.getString("question");
            opt1 = rs.getString("option1");
            opt2 = rs.getString("option2");
            opt3 = rs.getString("option3");
            opt4 = rs.getString("option4");
            answer = rs.getString("answer");
        }
        con.close();
    } catch(Exception e){ out.println(e.getMessage()); }
%>

<h2>Question <%= qIndex+1 %>:</h2>
<form action="test.jsp" method="post">
    <p><%= question %></p>
    <input type="radio" name="choice" value="<%=opt1%>" required> <%=opt1%><br>
    <input type="radio" name="choice" value="<%=opt2%>"> <%=opt2%><br>
    <input type="radio" name="choice" value="<%=opt3%>"> <%=opt3%><br>
    <input type="radio" name="choice" value="<%=opt4%>"> <%=opt4%><br><br>
    <input type="hidden" name="correct" value="<%=answer%>">
    <input type="submit" value="Next">
</form>

<%
if("POST".equalsIgnoreCase(request.getMethod())){
    String selected = request.getParameter("choice");
    String correctAns = request.getParameter("correct");
    if(selected.equals(correctAns)) score++;
    session.setAttribute("score", score);
    session.setAttribute("qIndex", qIndex+1);
    response.sendRedirect("test.jsp");
}
%>