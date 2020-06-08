<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en,ru">
<head>
    <meta charset="UTF-8">
    <title>AutoRia Search Request Dropdown lists</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>


    <script src="${pageContext.request.contextPath }/resources/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

            $('#comboboxCategory').on('change', function(){
                var categoryId = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadBrandsByCategory/' + categoryId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxBrand').html(s);
                    }
                });
            });


            $('#comboboxBrand').on('change', function(){
                var categoryId = $('#comboboxCategory').val();
                var brandId = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadModelsByCategoryAndBrand/' + categoryId + '/'+ brandId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxModel').html(s);
                    }
                });
            });


        });
    </script>
</head>
<body>
<p></p>
<c:import url="${contextPath}/WEB-INF/view/navibar.jsp"/>

<div class="container">


<%--@elvariable id="requestForm" type="com.berezovska.autoria.model.Request"--%>
<form:form method="POST" modelAttribute="requestForm" class="form-signin" action="/search">
    <h2 class="form-signin-heading">Search Details</h2>
    </div>
    <div class="container" >
    <table>
    <tr>
    <td>Category</td>
    <td>
    <spring:bind path="category">
         <select id="comboboxCategory" style="width:200px">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </spring:bind>
    </td>
    </tr>
    <tr>
    <td>Brand</td>
    <td>
    <spring:bind path="brand">
        <select id="comboboxBrand" style="width:200px"></select>
        <c:forEach var="brand" items="${brands}">
            <option value="${brand.id}">${brand.name}</option>
        </c:forEach>
    </spring:bind>
    </td>
    </tr>
    <tr>
    <td>Model</td>
    <td>
    <spring:bind path="model">
        <select id="comboboxModel" style="width:200px"></select>
        <c:forEach var="model" items="${models}">
            <option value="${model.id}">${model.name}</option>
        </c:forEach>
    </spring:bind>
    </td>
    </tr>
    </table>
    <input id="btnSave" type="submit" name="Save" value="Save" />
        </form:form>

    </div>
    </body>
</html>