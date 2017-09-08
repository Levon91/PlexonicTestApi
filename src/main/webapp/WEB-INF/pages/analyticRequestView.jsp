<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<div>
    <form action="analyticRequest.action" method="post">
        <table>
            <s:if test="%{hasFieldErrors()}">
                <tr>
                    <td><s:fielderror fieldName=""/></td>
                </tr>
            </s:if>
            <tr>
                <td>
                    <label id="date" for="date" about="Date">
                        <input type="date" data-date-inline-picker="true" name="date"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>
                    <button name="submit">Submit</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
