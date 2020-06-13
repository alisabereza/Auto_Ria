<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en,ru">
<head>
    <meta charset="UTF-8">
    <title>AutoRia Search Request Dropdown lists</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
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
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadBodiesByCategory/' + categoryId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxBody').html(s);
                    }
                });
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadDrivesByCategory/' + categoryId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxDrive').html(s);
                    }
                });

                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadGearboxesByCategory/' + categoryId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxGearbox').html(s);
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

            $('#comboboxRegion').on('change', function(){
                var regionId = $(this).val();
                $.ajax({
                    type: 'GET',
                    url: '${pageContext.request.contextPath }/search/loadCitiesByRegion/' + regionId,
                    success: function(result) {
                        var result = JSON.parse(result);
                        var s = '';
                        for(var i = 0; i < result.length; i++) {
                            s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
                        }
                        $('#comboboxCity').html(s);
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

    <spring:bind path="category">

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="category" id="comboboxCategory" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select Category</form:option>
                <c:forEach items="${categories}" var="category">
                    <form:option value="${category.id}">${category.name}</form:option>
                </c:forEach>
            </form:select>
        </div>

    </spring:bind>

    <spring:bind path="body">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="body" id="comboboxBody" class="form-control input-sm" autofocus="true">>
                <form:option value="">Select Body</form:option>
                <form:options items="${bodies}" />
            </form:select>
            <form:errors path="body"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="brand">

        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="brand" id="comboboxBrand" class="form-control input-sm" autofocus="true">>
                <form:option value="">Select Brand</form:option>
                <form:options items="${brands}" />
            </form:select>
            <form:errors path="brand"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="model">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="model" id="comboboxModel" class="form-control input-sm" autofocus="true">>
                <form:option value="">Select Model</form:option>
                <form:options items="${models}" />
            </form:select>
            <form:errors path="model"></form:errors>
        </div>
    </spring:bind>

    <spring:bind path="region">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="region" id="comboboxRegion" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select Region</form:option>
                <c:forEach items="${regions}" var="region">
                    <form:option value="${region.id}">${region.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
    </spring:bind>
    <spring:bind path="city">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="city" id="comboboxCity" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select City</form:option>
                <c:forEach items="${cities}" var="city">
                    <form:option value="${city.id}">${city.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
    </spring:bind>

    <spring:bind path="drive">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="drive" id="comboboxDrive" class="form-control input-sm" autofocus="true">>
                <form:option value="">Select Drive</form:option>
                <form:options items="${drives}" />
            </form:select>
            <form:errors path="body"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="fuel">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="fuel.name" id="comboboxFuel" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select Fuel</form:option>
                <c:forEach items="${all_fuel}" var="fuel">
                    <form:option value="${fuel.name}">${fuel.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
    </spring:bind><spring:bind path="gearbox">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:select path="gearbox" id="comboboxGearbox" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select Gearbox</form:option>
                <c:forEach items="${gearboxes}" var="gearbox">
                    <form:option value="${gearbox.name}">${gearbox.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
    </spring:bind>

    <spring:bind path="colour">
        <div class="form-group ${status.error ? 'has-error' : ''}">

            <form:select path="colour" id="comboboxColour" class="form-control input-sm" autofocus="true">
                <form:option value="2">Select Colour</form:option>
                <c:forEach items="${colours}" var="colour">
                    <form:option value="${colour.name}">${colour.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
    </spring:bind>
    <spring:bind path="priceMin">
        <div class="form-group ${status.error ? 'has-error' : ''}">

            <form:input type="text" path="priceMin" class="form-control" placeholder="Price Min"
                        autofocus="true"></form:input>
            <form:errors path="priceMin"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="priceMax">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="priceMax" class="form-control" placeholder="Price Max"
                        autofocus="true"></form:input>
            <form:errors path="priceMax"></form:errors>
        </div>
    </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" id="btnSave" type="submit">Save</button>
 </form:form>

    </div>
    </body>
</html>