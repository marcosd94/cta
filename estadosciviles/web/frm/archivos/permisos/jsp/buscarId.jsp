<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.PermisosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Permisos"%>
<%

int id_permisos= Integer.parseInt(request.getParameter("id_permisos"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Permisos permisos= PermisosControlador.buscarId(id_permisos);
if (permisos != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    permisos= new Permisos();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_permisos", permisos.getId_permisos());
obj.put("nombre_permisos", permisos.getNombre_permisos());

out.print(obj);
out.flush();
%>
