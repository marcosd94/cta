<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.MenusControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Menus"%>
<%
int id_menus= Integer.parseInt(request.getParameter("id_menus"));
String nombre_menus = request.getParameter("nombre_menus");
String codigo_menus = request.getParameter("codigo_menus");



String tipo="error";
String mensaje= "Datos no Agregados";

Menus menus= new Menus();
menus.setId_menus(id_menus);
menus.setNombre_menus(nombre_menus);
menus.setCodigo_menus(codigo_menus);

if(MenusControlador.agregar(menus)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>