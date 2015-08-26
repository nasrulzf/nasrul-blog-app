<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href='<spring:url value="/style/css/bootstrap.css" />' >
		<link rel="stylesheet" href='<spring:url value="/style/css/custom.css" />' >
		<style type="text/css">
		
		body {
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #eee;
		}
		
		.form-signin {
		  max-width: 330px;
		  padding: 15px;
		  margin: 0 auto;
		}
		.form-signin .form-signin-heading,
		.form-signin .checkbox {
		  margin-bottom: 10px;
		}
		.form-signin .checkbox {
		  font-weight: normal;
		}
		.form-signin .form-control {
		  position: relative;
		  height: auto;
		  -webkit-box-sizing: border-box;
		     -moz-box-sizing: border-box;
		          box-sizing: border-box;
		  padding: 10px;
		  font-size: 16px;
		}
		.form-signin .form-control:focus {
		  z-index: 2;
		}
		.form-signin input[type="email"] {
		  margin-bottom: -1px;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
		.form-signin input[type="password"] {
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
		
		</style>
	</head>
	<body>
		<div class="container">
	      <div class="header clearfix">
	        <nav>
	          <ul class="nav nav-pills pull-right">
	          	<li role="presentation" class="active"><a href='<spring:url value="/index.do"></spring:url>'>Home</a></li>
	          	<li role="presentation"><a href='<spring:url value="/artikel/index.do"></spring:url>'>Index</a></li>
	          	<security:authorize access="hasRole('ROLE_ADMIN')">
	          		<li role="presentation"><a href='<spring:url value="/admin/list-kategori.do"></spring:url>'>Kategori</a></li>
	          		<li role="presentation"><a href='<spring:url value="/admin/list-artikel.do"></spring:url>'>Artikel</a></li>
	          	</security:authorize>
	          	<security:authorize access="! isAuthenticated()">
	          		<li role="presentation"><a href='<spring:url value="/login.do"></spring:url>'>Login</a></li>
	          	</security:authorize>
	          	<security:authorize access="isAuthenticated()">
	          	<li role="presentation"><a href='<spring:url value="/account.do"></spring:url>'>Akun</a></li>
	          	<li role="presentation"><a href='<spring:url value="/logout"></spring:url>'>Logout</a></li>
	          	</security:authorize>
	          </ul>
	        </nav>
	        <h3 class="text-muted">Blog Nasrul</h3>
	      </div>
		<tiles:insertAttribute name="body" />
		<center>
		<tiles:insertAttribute name="footer" />
		</center>
		</div>
	</body>
</html>