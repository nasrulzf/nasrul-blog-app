<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form class="form-signin" method="POST" action="/j_spring_security_check">
  <h2 class="form-signin-heading">Please sign in</h2>
  <label for="j_username" class="sr-only">Username</label>
  <input type="text" name="j_username" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
  <label for="j_password" class="sr-only">Password</label>
  <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
