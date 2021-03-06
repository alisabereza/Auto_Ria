<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>

    <div class="dropdown">
        <button class="dropbtn">Data
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/data/updateData">Update Data</a>
            <a href="${pageContext.request.contextPath}/search">Search</a>
        </div>
    </div>
    <security:authorize access="hasRole('ROLE_ADMIN')">
    <div class="dropdown">
        <button class="dropbtn">User
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/user/showUsers">Show Users</a>
            <a href="${pageContext.request.contextPath}/user/createUser">Create User</a>
            <a href="${pageContext.request.contextPath}/user/findPage">Find User</a>
        </div>
    </div>
    </security:authorize>
    <div>
        <a style="float: right" href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
    <div>
        <p><security:authentication property="principal.username"/></p>
    </div>
</div>