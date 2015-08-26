<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:forEach items="${artikel}" var="artikel">
<div class="page-header">
  <h1><a href='<spring:url value="/${artikel.judulSeo}-${artikel.id}.do"></spring:url>'>${artikel.judul}</a></h1>
</div>
<div class="panel panel-default">
  <div class="panel-heading">Published on ${artikel.publishedDate} by ${artikel.penulis.namaLengkap}</div>
  <div class="panel-body">
    ${artikel.isiArtikel}
  </div>
</div>
</c:forEach>
