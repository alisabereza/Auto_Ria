<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <%--@elvariable id="searchForm" type="categoryBrandModelLink"--%>
    <form:form method="POST" modelAttribute="searchForm" class="form-signin" action="/data/search">
        <h2 class="form-signin-heading">Search Details</h2>
 </div>
<div class="container" >
    <spring:bind path="id">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:hidden path="id" class="form-control" placeholder="ID"></form:hidden>
                        <form:errors path="id"></form:errors>
                    </div>
    </spring:bind>




        <spring:bind path="category">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="category" id="category" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Category</form:option>
                    <form:options items="${categoryBrandModelList.category.name}" />
                </form:select>
                <form:errors path="category"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="region">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:select path="brand" id="brand" class="form-control input-sm" autofocus="true">>
                    <form:option value="">Select Brand</form:option>
                    <form:options items="${categoryBrandModelList.brand.name}" />
                </form:select>
                <form:errors path="brand"></form:errors>
            </div>
        </spring:bind>

    <spring:bind path="model">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="model" id="model" class="form-control input-sm" autofocus="true">>
                <form:option value="">Select Model</form:option>
                <form:options items="${categoryBrandModelList.model.name}" />
            </form:select>
            <form:errors path="model"></form:errors>
        </div>
    </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
    </form:form>
</div>

</body>
</html>
