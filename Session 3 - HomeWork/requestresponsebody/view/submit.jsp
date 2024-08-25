<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Submission Result</title>
</head>
<body>
    <h2>Submitted Information</h2>
    Name: <%= request.getParameter("name") %><br/><br/>
    Family: <%= request.getParameter("family") %><br/><br/>
    Year of Birth: <%= request.getParameter("yearOfBirth") %><br/><br/>

</body>
</html>