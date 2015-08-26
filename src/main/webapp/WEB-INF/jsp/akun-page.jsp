<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h3>Account Information</h3>
<div class="panel panel-default">
	<div class="panel-body">
		<form:form cssClass="form-signin" commandName="user">
		  <label for="j_username" class="sr-only">Username</label>
		  <form:input path="username" cssClass="form-control" />
		  <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
		</form:form>
	</div>
</div>
