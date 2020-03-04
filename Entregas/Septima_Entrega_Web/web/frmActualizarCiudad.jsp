<%-- 
    Document   : frmActualizarCiudad
    Created on : 04-mar-2020, 18:25:21
    Author     : patri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="ciudad" scope="request" class="ORM.Ciudad"/> 
<jsp:setProperty name="ciudad" property="*"/> 
<!DOCTYPE html> 
<html> 
	<head> 
		<meta http-equiv="ContentType" content="text/html; charset=UTF-8"> 
		<title>Actualizar Ciudad</title> 
	</head>
	<body> 
		<form method="post" action="controlador"> 
			<table> 
				<tr> 
					<td> 
						<input type="hidden" name="op" value="actCiudad"/>
                                                <input type="hidden" name="idCiudad" value="<%=ciudad.getIdCiudad()%>"/>
                                                <p>Nombre:</p>
						<input name="nombre" required type="text" size="20"  maxlength="20"/> 
                                                <p>Pais:</p>
                                                <input name="pais" required type="text" size="20"  maxlength="20"/> 
                                                <p>Numero de Habitantes:</p>
                                                <input name="numHabitantes" required type="number" size="20"  maxlength="20"/> 
                                                <p></p>
                                                <!--<input name="idCiudad" value="<%=ciudad.getIdCiudad()%>"/>
                                                <p>Nombre:</p>
						<input name="nombre" required type="text" value="<%=ciudad.getNombre()%>" size="20"  maxlength="20"/> 
                                                <p>Pais:</p>
                                                <input name="pais" required type="text" value="<%=ciudad.getPais()%>" size="20"  maxlength="20"/> 
                                                <p>Numero de Habitantes:</p>
                                                <input name="numHabitantes" required type="number" value="<%=ciudad.getNumHabitantes()%>" size="20"  maxlength="20"/> 
                                                <p></p>-->
					</td> 
				</tr> 
				<tr> 
					<td> 
						<input type="submit" value="Actualizar"/> 
						<input type="reset" name="cancelar" value="Cancelar"/> 
					</td> 
				</tr> 
			</table> 
		</form> 
		<a href="controlador">Inicio</a> 
	</body> 
</html> 
