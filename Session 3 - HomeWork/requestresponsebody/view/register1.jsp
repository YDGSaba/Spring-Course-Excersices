<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration Form</h2>
    <form action="register.jsp" method="post">
        Name: <input type="text" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>" />
        <% if ("true".equals(request.getAttribute("nameError"))) { %>
            <span>Name is required</span>
        <% } %>
        <br/><br/>

        Family: <input type="text" name="family" value="<%= request.getParameter("family") != null ? request.getParameter("family") : "" %>" />
        <% if ("true".equals(request.getAttribute("familyError"))) { %>
            <span>Family is required</span>
        <% } %>
        <br/><br/>

        Year of Birth: 
        <select name="yearOfBirth">
            <% 
                int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                String selectedYear = request.getParameter("yearOfBirth");
                for (int i = 1950; i <= currentYear; i++) {
            %>
                <option value="<%=i%>" <%= i == Integer.parseInt(selectedYear != null ? selectedYear : "0") ? "selected" : "" %>><%=i%></option>
            <% } %>
        </select><br/><br/>

        <input type="submit" value="Submit" />
    </form>

    <%
        String name = request.getParameter("name");
        String family = request.getParameter("family");

        boolean hasError = false;

        if (name == null || name.isEmpty()) {
            request.setAttribute("nameError", "true");
            hasError = true;
        }

        if (family == null || family.isEmpty()) {
            request.setAttribute("familyError", "true");
            hasError = true;
        }

        if (hasError) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if (name != null && family != null) {
            response.sendRedirect("submit.jsp?name=" + name + "&family=" + family + "&yearOfBirth=" + request.getParameter("yearOfBirth"));
        }
    %>
</body>
</html>
