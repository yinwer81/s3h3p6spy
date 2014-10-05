<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>s3h3</title>
</head>
<body>
    <h2>s3h3</h2>
    <form:form method="post" action="add" commandName="user">
        <table>
            <tr>
                <td><form:label path="firstname">
                        <spring:message code="label.firstname" />
                    </form:label></td>
                <td><form:input path="firstname" /></td>
            </tr>
            <tr>
                <td><form:label path="lastname">
                        <spring:message code="label.lastname" />
                    </form:label></td>
                <td><form:input path="lastname" /></td>
            </tr>
            <tr>
                <td><form:label path="email">
                        <spring:message code="label.email" />
                    </form:label></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td><form:label path="telephone">
                        <spring:message code="label.telephone" />
                    </form:label></td>
                <td><form:input path="telephone" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"
                    value="<spring:message code="label.add"/>" /></td>
            </tr>
        </table>
    </form:form>


    <h3>Users</h3>
    <c:if test="${!empty userList}">
        <table class="data">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.lastname},${user.firstname}</td>
                    <td>${user.email}</td>
                    <td>${user.telephone}</td>
                    <td><a href="delete/${user.id}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>