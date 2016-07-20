<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.PermisosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Permisos"%>
<%
int id_permisos= Integer.parseInt(request.getParameter("id_permisos"));
String nombre_permisos = request.getParameter("nombre_permisos");


String tipo="error";
String mensaje= "Datos no Agregados";

Permisos permisos= new Permisos();
permisos.setId_permisos(id_permisos);
permisos.setNombre_permisos(nombre_permisos);

if(PermisosControlador.agregar(permisos)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>