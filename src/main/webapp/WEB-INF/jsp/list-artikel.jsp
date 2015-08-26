<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<a class="btn btn-success" href='<spring:url value="/admin/artikel-add.do" />' style="margin:5px;">Tambah Artikel</a>
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Judul</th>
			<th>Kategori</th>
			<th>Published</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listartikel}" var="artikel">
		<tr>
			<td>${artikel.id}</td>
			<td><a href='<spring:url value="/admin/artikel-update/${artikel.id}.do" />'>${artikel.judul}</a></td>
			<td>${artikel.kategori.namaKategori}</td>
			<td>${artikel.publishedDate}</td>
			<td><a href="<spring:url value="/admin/artikel-delete/${artikel.id}.do" />">Hapus</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div class="text-center">
	<nav>
	  <ul class="pagination">
	  	<c:if test="${hasPrev}" var="true">
	    <li>
	      <a href="<spring:url value="${curPages - 1}.do" />" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    </c:if>
	    <c:forEach begin="1" end="${totalPages}" step="1" var="x">
	    <li class="${ (x == curPages) ? 'active' : '' }"><a href='<spring:url value="/admin/list-artikel/${x}.do"></spring:url>'> ${x} </a></li>
	    </c:forEach>
	    <c:if test="${hasNext}" var="true">
	    <li>
	      <a href='<spring:url value="${curPages + 1}.do" />' aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	    </c:if>
	  </ul>
	</nav>
</div>