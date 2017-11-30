<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head></head>

<body>
	<h1>Login</h1>

	<form name='f' action="/perform_login" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='user_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='user_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td><a href="/registration">Create an account</a></td>
			</tr>
		</table>
	</form>
    <c:if test="${not empty auth_status}">
        <div style="color:red">
            Login failed.
            Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

        </div>
    </c:if>

</body>
</html>