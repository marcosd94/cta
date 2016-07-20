<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.RolesControlador"%>
<%@page import="jsppostgres.modelos.Roles"%>
<%

int id_roles= Integer.parseInt(request.getParameter("id_roles"));


String tipo="error";
String mensaje= "Datos no eliminados";

Roles roles= new Roles();
roles.setId_roles(id_roles);

if(RolesControlador.eliminar(roles)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
