<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head></head>

<body>

<div>

    <form:form method="POST" modelAttribute="registrationForm" action="/registration">
        <h2>Create your account</h2>

        <spring:bind path="surname">
            <h4>Name: </h4>
            <div>
                <form:input type="text" path="surname" placeholder="Surname" autofocus="true"></form:input>
                <form:errors path="surname"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <h4>Name: </h4>
            <div>
                <form:input type="text" path="firstName" placeholder="Firstname" autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="Login">
            <h4>Name: </h4>
            <div>
                <form:input type="text" path="login" placeholder="Login" autofocus="true"></form:input>
                <form:errors path="login"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="birthdate">
            <h4>Birth date: </h4>
            <div>
                <form:input type="text" path="birthDate" placeholder="Birth date" autofocus="true"></form:input>
                <form:errors path="birthDate"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <h4>Email: </h4>
            <div>
                <form:input type="text" path="email" placeholder="Email"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="street">
            <h4>Street: </h4>
            <div>
                <form:input type="text" path="street" placeholder="Street"></form:input>
                <form:errors path="street"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <h4>City: </h4>
            <div>
                <form:input type="text" path="city" placeholder="City"></form:input>
                <form:errors path="city"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="country">
            <h4>Country: </h4>
            <div>
                <form:input type="text" path="country" placeholder="Email"></form:input>
                <form:errors path="country"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="zipcode">
            <h4>Zipcode: </h4>
            <div>
                <form:input type="text" path="zipcode" placeholder="Zipcode"></form:input>
                <form:errors path="zipcode"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <h4>Password: </h4>
            <div>
                <form:input type="password" path="password" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <h4>Password Confirmation: </h4>
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
