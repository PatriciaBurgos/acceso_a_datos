<%-- 
    Document   : muestraCiudad
    Created on : 04-mar-2020, 11:40:13
    Author     : patri
--%>

<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="ciudad" scope="request" class="ORM.Ciudad"/>
<jsp:setProperty name="ciudad" property="*"/>

<%
    ORM.Ciudad ciudadBean = (ORM.Ciudad) request.getAttribute("ciudad"); 
    if (ciudadBean == null) {
%>
ERROR: no se especific&oacute; ciudad a mostrar.
<%
} else {
    Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
		try  { 
                    s.refresh(ciudadBean);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ciudad <%=ciudadBean.getIdCiudad()%> - <%=ciudadBean.getNombre()%></title>
    </head>
    <body>
        <form name="frm_nueva_ciudad" method="post" action="controlador">
           <input type="hidden" name="op" value="muestraCiudad">
           <input type="hidden" name="idCiudad" value="<%=ciudadBean.getIdCiudad()%>">
        
                <p>CIUDAD</p> 
                <p>ID: <%=ciudadBean.getIdCiudad()%></p>
                <p>NOMBRE: <%=ciudadBean.getNombre()%></p> 
                <p>PAIS: <%=ciudadBean.getPais()%> </p>
                <p>NUMERO DE HABITANTES: <%=ciudadBean.getNumHabitantes()%></p>
               
        </form>
    </body>
</html>
<%
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
%>