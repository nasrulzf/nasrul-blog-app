<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form commandName="kategori">

	<div class="form-group">
       <label for="namaKategori">Nama Kategori</label>
       <form:input path="namaKategori" cssClass="form-control" />
       <form:hidden path="id"/>
       <form:hidden path="namaSeo"/>
     </div>
     <input type="submit" value="Simpan" class="btn btn-primary" />

</form:form>
