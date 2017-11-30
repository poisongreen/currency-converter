<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<body>
	<div>
		<div>
			<h1>Dashboard</h1>
			<h2>Hello <sec:authentication property="principal.username" /></h2>
			<a href="<c:url value="/perform_logout" />">Logout</a>
		</div>
	</div>
</body>
</html>
