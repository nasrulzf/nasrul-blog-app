<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="page-header">
  <h1><a href='<spring:url value="/${artikel.judulSeo}-${artikel.id}.do"></spring:url>'>${artikel.judul}</a></h1>
</div>
<p>Published on ${artikel.publishedDate} by ${artikel.penulis.namaLengkap}</p>
<p>${artikel.isiArtikel}</p>
<div class="panel panel-default">
  <div class="panel-heading">Komentar</div>
  <div class="panel-body">
    <c:forEach items="${artikel.komentar}" var="komentar">
    	 Komentar oleh ${komentar.user} <br>
    	 ${komentar.isiKomentar}
    	 <hr>
    </c:forEach>
  </div>
</div>