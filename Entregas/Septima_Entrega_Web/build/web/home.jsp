<%-- 
    Document   : home
    Created on : 04-mar-2020, 11:20:11
    Author     : patri
--%>

<%@page import= "org.hibernate.Session" %>
<%@page import= "java.util.List" %>
<%@page import= "org.hibernate.Query" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>JSP Page</title>
   </head>
   <body>
        <form name="frm_muestra_ciudad" method="post" action="controlador">
           <input type="hidden" name="op" value="muestraCiudad">
           <input type="hidden" name="idCiudad">
           
           <table border="1">
               <tr<td colspan="2" align="center"> Ciudades [<a href="javascript:void(0)" onclick="javascript:document.frm_muestra_ciudad.op.value='altaCiudad'; document.frm_muestra_ciudad.submit();">Nueva Ciudad</a>]</td></tr>
               <%
                   Session s = ORM.NewHibernateUtil.getInstance().getSessionFactory().openSession();
                   try{
                       Query q = s.createQuery("FROM Ciudad ORDER BY "
                               + "nombre,idCiudad").setReadOnly(true);
                       List<ORM.Ciudad> listaCiudades = (List<ORM.Ciudad>)
                               q.list();
                       
                       if(listaCiudades.isEmpty()) { %>
                       <tr><td colspan="2">No existen ciudades</td></tr>
                       <%
                   } else {%>
                        <tr>
                           <td>ID</td>
                           <td>Nombre</td>
                           <td>Pais</td>
                           <td>NumeroHabitantes</td>
                        </tr>
                       <%
                       for(ORM.Ciudad unaCiudad: listaCiudades){%>
                       <tr>
                           <td><%=unaCiudad.getIdCiudad()%></td>
                           <td><a href="javascript:void(0)" onclick="javascript:document.frm_muestra_ciudad.idCiudad.value = '<%=unaCiudad.getIdCiudad()%>'; document.frm_muestra_ciudad.submit()"><%=unaCiudad.getNombre()%></a></td>
                           <td><%=unaCiudad.getPais()%></td>
                           <td><%=unaCiudad.getNumHabitantes()%></td>
                           <td><input type="button" value="Borrar" onclick="javascript:document.frm_muestra_ciudad.op.value='eliminarCiudad'; document.frm_muestra_ciudad.idCiudad.value = '<%=unaCiudad.getIdCiudad()%>'; document.frm_muestra_ciudad.submit()"></td>
                           <!--<td><input type="button" value="Actualizar" onclick="javascript:document.frm_muestra_ciudad.op.value='actualizarCiudad'; document.frm_muestra_ciudad.idCiudad.value = '<%=unaCiudad.getIdCiudad()%>'; document.frm_muestra_ciudad.nombre.value = '<%=unaCiudad.getNombre()%>'; document.frm_muestra_ciudad.pais.value = '<%=unaCiudad.getPais()%>'; document.frm_muestra_ciudad.numHabitantes.value = '<%=unaCiudad.getNumHabitantes()%>'; document.frm_muestra_ciudad.submit()"></td>-->
                           <td><input type="button" value="Actualizar" onclick="javascript:document.frm_muestra_ciudad.op.value='actualizarCiudad'; document.frm_muestra_ciudad.idCiudad.value = '<%=unaCiudad.getIdCiudad()%>'; document.frm_muestra_ciudad.submit()"></td>
                       </tr>
                   <%    
               }
           }
       }catch (Exception e){
           e.printStackTrace(System.err);
       }
       %>
                   
           </table>
   </body>
</html>