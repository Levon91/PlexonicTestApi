<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Integer statusCode = (Integer) request
            .getAttribute("javax.servlet.error.status_code");

    response.sendRedirect(getServletConfig().getServletContext().getContextPath()
            + "/error.action?statusCode=" + statusCode);
%>
</body>
</html>
