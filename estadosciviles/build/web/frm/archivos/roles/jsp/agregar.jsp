<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.RolesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Roles"%>
<%
int id_roles= Integer.parseInt(request.getParameter("id_roles"));
String nombre_roles = request.getParameter("nombre_roles");


String tipo="error";
String mensaje= "Datos no Agregados";

Roles roles= new Roles();
roles.setId_roles(id_roles);
roles.setNombre_roles(nombre_roles);

if(RolesControlador.agregar(roles)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>