<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="ForoController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Titulo</th>
			 <th>Descripción</th>
			 <th>Estado</th>
			 
			  
			
		</tr>
		
		<c:forEach var="foro" items="${foros}">
		
		<tr>
			<td>
				<form action= "ForoController">
					<input type = "hidden" name = "id" value= "${foro.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${foro.id}</td>
			<td> ${foro.titulo}</td>
			<td> ${foro.descripcion}</td>
			<td> ${foro.estado}</td>
			
		</tr>
		
		</c:forEach>
		
	
	</table>

<form action="ForoReport">
				
					<input type = "submit" name = "btn_reporte" value = "Generar Reporte"/>
				</form>
</body>
</html>