<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/></head>
<body>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>
<h3>Error message:  ${error}</h3>
</body>
</html>