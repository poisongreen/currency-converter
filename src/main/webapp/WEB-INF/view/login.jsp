<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>

    <link rel="stylesheet" href="resources/css/jquery-ui.min.css"/>
    <link rel="stylesheet" href="resources/css/jquery-ui.structure.min.css"/>
    <link rel="stylesheet" href="resources/css/jquery-ui.theme.min.css"/>
<body>
<style>
    .rTable    { display: table; border-spacing: 10px; }
    .rTableRow       { display: table-row; }
    .rTableBody    { display: table-row-group; }
    .rTableFoot    { display: table-footer-group; }
    .rTableCell { display: table-cell; }

</style>
</body>
</head>

<body>

<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>

<h1>Login</h1>

<form name='f' action="/perform_login" method='POST' class=".ui-widget">

    <div class="rTable">
        <div class="rTableRow">
            <div class="rTableCell">User:</div>
            <div class="rTableCell"><input type='text' name='user_username' value=''></div>
        </div>
        <div class="rTableRow">
            <div class="rTableCell">Password:</div>
            <div class="rTableCell"><input type='password' name='user_password'/></div>
        </div>

        <div class="rTableRow">
            <div class="rTableCell"><input class="ui-button ui-widget ui-corner-all" name="submit" type="submit"
                                           value="Login"/></div>
        </div>

        <div class="rTableRow">
            <div class="rTableCell"><a href="/registration">Create an account</a></div>
        </div>

    </div>
</form>
<c:if test="${not empty auth_status}">
    <div style="color:red">
        Login failed.
        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

    </div>
</c:if>

</body>
</html>