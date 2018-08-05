<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Calculator-divide</title>
</head>
<body>

<form:form method="post" action="divide">
    <table>
        <tr>
            <td><form:label path="firstArgument">firstArgument</form:label></td>
            <td><form:input path="firstArgument"/></td>
        </tr>
        <tr>
            <td><form:label path="secondArgument">secondArgument</form:label></td>
            <td><form:input path="secondArgument"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="/"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>