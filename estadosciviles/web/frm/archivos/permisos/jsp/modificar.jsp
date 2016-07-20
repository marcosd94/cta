<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.PermisosControlador"%>
<%@page import="jsppostgres.modelos.Permisos"%>
<%

int id_permisos= Integer.parseInt(request.getParameter("id_permisos"));
String nombre_permisos = request.getParameter("nombre_permisos");

String tipo="error";
String mensaje= "Datos no modificados";

Permisos permisos= new Permisos();
permisos.setId_permisos(id_permisos);
permisos.setNombre_permisos(nombre_permisos);

if(PermisosControlador.modificar(permisos)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>