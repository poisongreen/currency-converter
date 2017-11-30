<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head></head>

<body>

<div>

    <form:form method="POST" modelAttribute="registrationForm" action="/registration">
        <h2>Create your account</h2>

        <spring:bind path="username">
            <h1>Name: </h1>
            <div>
                <form:input type="text" path="username"  placeholder="Username" autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <h1>Email: </h1>
            <div>
                <form:input type="text" path="email" placeholder="Email"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <h1>Password: </h1>
            <div >
                <form:input type="password" path="password" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <h1>Password Confirmation: </h1>
            <div>
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>
    </form:form>

</div>

</body>
</html>
