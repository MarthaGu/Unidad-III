<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ForoController">
		<label>Titulo:</label><br>
		<input type = "text" name= "titulo" value = "${foro.titulo}" /><br>
		
		<label>Descripción:</label><br>
		<input type = "text" name= "descripcion" value = "${foro.descripcion}" /><br>
		
		<label>Estado:</label><br>
		<input type = "text" name= "estado" value = "${foro.estado}" /><br>
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>