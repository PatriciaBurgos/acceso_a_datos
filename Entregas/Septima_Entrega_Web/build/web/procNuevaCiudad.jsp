<%-- 
    Document   : procNuevaCiudad
    Created on : 04-mar-2020, 11:35:14
    Author     : patri
--%>

<%@page import="org.hibernate.Session"%> 
<%@page import="org.hibernate.Transaction"%> 
<%@page import="org.hibernate.Query"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:useBean id="ciudad" scope="request" class="ORM.Ciudad"/> 
<jsp:setProperty name="ciudad" property="*"/> 
<!DOCTYPE html> 
<html> 
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<title>Creación de Ciudad</title> 
	</head> 
	<body> 
		<% 
			ORM.Ciudad ciudadBean = (ORM.Ciudad) request.getAttribute("ciudad");  
			if (ciudadBean == null) { 
		%> 
                <%=request.getAttribute("nom_ciudad")%>
			ERROR: no se proporcionaron datos de ciudad para crear.
		<% } 
			else { 
				Transaction t = null; 
                                Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
				try  { 
					t = s.beginTransaction(); 
					s.save(ciudadBean); 
					t.commit(); 
					%>
					Creada nueva ciudad [<%=ciudadBean.getIdCiudad()%>] <%=ciudadBean.getNombre()%><br/> 
					<a href="controlador">Volver</a> 
				<% } 
				catch (Exception e) { 
				e.printStackTrace(System.err); 
				if (t != null) { 
					t.rollback(); 
				}
			} 
		} %> 
	</body> 
</html> 