<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration Form</h2>
    <form action="submit.jsp" method="post">
        Name: <input type="text" name="name" /><br/><br/>
        Family: <input type="text" name="family" /><br/><br/>
        Year of Birth: 
        <select name="yearOfBirth">
            <% 
                int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                for (int i = 1950; i <= currentYear; i++) {
            %>
                <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select><br/><br/>

        <input type="submit" value="Submit" />
    </form>
</body>
</html>
