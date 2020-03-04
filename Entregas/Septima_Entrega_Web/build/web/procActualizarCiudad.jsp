<%-- 
    Document   : procActualizarCiudad
    Created on : 04-mar-2020, 18:31:23
    Author     : patri
--%>

<%@page import="ORM.Ciudad"%>
<%@page import="java.util.List"%>
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
		<title>Actualizacion de Ciudad</title> 
	</head> 
	<body> 
		<% 
			ORM.Ciudad ciudadBean = (ORM.Ciudad) request.getAttribute("ciudad");  
			if (ciudadBean == null) { 
		%> 
                <%=request.getAttribute("nom_ciudad")%>
			ERROR: no se proporcionaron datos de ciudad para actualizar.
		<% } 
			else { 
				Transaction t = null; 
                                Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
				try  { 
                                        List<ORM.Ciudad> listciu = s.createQuery("FROM Ciudad WHERE id_ciudad = '" + ciudadBean.getIdCiudad()+ "'").list();
                                        Ciudad ciu_nue = listciu.get(0);
                                        ciu_nue.setNombre(ciudadBean.getNombre());
                                        ciu_nue.setPais(ciudadBean.getPais());
                                        ciu_nue.setNumHabitantes(ciudadBean.getNumHabitantes());
                                        t = s.beginTransaction(); 
                                        s.update(ciu_nue); 
                                        t.commit();
                                        s.refresh(ciu_nue);
                                        s.close();


					%>
					Actualizada ciudad [<%=ciudadBean.getIdCiudad()%>] <%=ciudadBean.getNombre()%>, <%=ciudadBean.getPais()%>, <%=ciudadBean.getNumHabitantes()%><br/> 
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