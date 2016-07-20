<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.RolesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Roles"%>
<%

int id_roles= Integer.parseInt(request.getParameter("id_roles"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Roles roles= RolesControlador.buscarId(id_roles);
if (roles != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    roles= new Roles();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_roles", roles.getId_roles());
obj.put("nombre_roles", roles.getNombre_roles());

out.print(obj);
out.flush();
%>
