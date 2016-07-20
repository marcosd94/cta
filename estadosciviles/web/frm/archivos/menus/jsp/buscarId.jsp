<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.MenusControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Menus"%>
<%

int id_menus= Integer.parseInt(request.getParameter("id_menus"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Menus menus= MenusControlador.buscarId(id_menus);
if (menus != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    menus= new Menus();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_menus", menus.getId_menus());
obj.put("nombre_menus", menus.getNombre_menus());
obj.put("codigo_menus", menus.getCodigo_menus());

out.print(obj);
out.flush();
%>
