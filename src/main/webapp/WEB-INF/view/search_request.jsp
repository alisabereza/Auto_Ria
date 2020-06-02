<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Search Form</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
</head>

<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<div class="container">
    <form:form method="POST" modelAttribute="searchForm" class="form-signin" action="/data/search">
        <h2 class="form-signin-heading">Search Details</h2>
        <%--        <spring:bind path="id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:hidden path="id" class="form-control" placeholder="ID"></form:hidden>
                        <form:errors path="id"></form:errors>
                    </div>
                </spring:bind>--%>

        <spring:bind path="category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="category" class="form-control" placeholder="Category"
                            autofocus="true"></form:input>
                <form:errors path="category"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="body">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="body" class="form-control" placeholder="Body"
                            autofocus="true"></form:input>
                <form:errors path="body"></form:errors>
            </div>
        </spring:bind>

        <span>${message}</span>
        <spring:bind path="brand">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="brand" class="form-control" placeholder="Brand"
                            autofocus="true"></form:input>
                <form:errors path="brand"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="model">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="model" class="form-control" placeholder="Model"
                            autofocus="true"></form:input>
                <form:errors path="model"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="region">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="region" id="region" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Region</form:option>
                    <form:options items="${regions}" />
                </form:select>
                <form:errors path="region"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="city" id="city" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Citys</form:option>
                    <form:options items="${userStatuses}" />
                </form:select>
                <form:errors path="city"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
</div>

</body>
</html>