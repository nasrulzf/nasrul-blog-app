<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form commandName="artikel">

	<div class="form-group">
	   <form:hidden path="id"/>
       <form:hidden path="judulSeo"/>
       <label for="judul">Judul</label>
       <form:input path="judul" cssClass="form-control" />
       <label for="kategori">Kategori</label>
       <form:select path="kategori" cssClass="form-control">
       	<c:forEach items="${listkategori}" var="kategori">
       		<form:option value="${kategori.id}">${kategori.namaKategori}</form:option>
       	</c:forEach>
       </form:select>
       <label for="isiArtikel">Artikel</label>
       <form:textarea path="isiArtikel" cssClass="form-control" />
     </div>
     <input type="submit" value="Simpan" class="btn btn-primary" />

</form:form>
