<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.RolesControlador"%>
<%@page import="jsppostgres.modelos.Roles"%>
<%

int id_roles= Integer.parseInt(request.getParameter("id_roles"));
String nombre_roles = request.getParameter("nombre_roles");

String tipo="error";
String mensaje= "Datos no modificados";

Roles roles= new Roles();
roles.setId_roles(id_roles);
roles.setNombre_roles(nombre_roles);

if(RolesControlador.modificar(roles)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>