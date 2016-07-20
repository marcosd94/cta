<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.PermisosControlador"%>
<%@page import="jsppostgres.modelos.Permisos"%>
<%

int id_permisos= Integer.parseInt(request.getParameter("id_permisos"));


String tipo="error";
String mensaje= "Datos no eliminados";

Permisos permisos= new Permisos();
permisos.setId_permisos(id_permisos);

if(PermisosControlador.eliminar(permisos)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
