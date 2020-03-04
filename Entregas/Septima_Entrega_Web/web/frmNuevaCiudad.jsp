<%-- 
    Document   : frmNuevaCiudad
    Created on : 04-mar-2020, 11:38:44
    Author     : patri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="ciudad" scope="request" class="ORM.Ciudad"/> 
<jsp:setProperty name="ciudad" property="*"/> 
<!DOCTYPE html> 
<html> 
	<head> 
		<meta http-equiv="ContentType" content="text/html; charset=UTF-8"> 
		<title>Alta de Ciudad</title> 
	</head>
	<body> 
		<form method="post" action="controlador"> 
			<table> 
				<tr> 
					<td> 
						<input type="hidden" name="op" value="insertCiudad"/> 
                                                <p>Nombre:</p>
						<input name="nombre" required type="text" size="20"  maxlength="20"/> 
                                                <p>Pais:</p>
                                                <input name="pais" required type="text" size="20"  maxlength="20"/> 
                                                <p>Numero de Habitantes:</p>
                                                <input name="numHabitantes" required type="number" size="20"  maxlength="20"/> 
                                                <p></p>
					</td> 
				</tr> 
				<tr> 
					<td> 
						<input type="submit" value="Crear"/> 
						<input type="reset" name="cancelar" value="Cancelar"/> 
					</td> 
				</tr> 
			</table> 
		</form> 
		<a href="controlador">Inicio</a> 
	</body> 
</html> 
