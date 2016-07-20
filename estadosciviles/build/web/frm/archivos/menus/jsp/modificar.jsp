<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.MenusControlador"%>
<%@page import="jsppostgres.modelos.Menus"%>
<%

int id_menus= Integer.parseInt(request.getParameter("id_menus"));
String nombre_menus = request.getParameter("nombre_menus");
String codigo_menus = request.getParameter("codigo_menus");

String tipo="error";
String mensaje= "Datos no modificados";

Menus menus= new Menus();
menus.setId_menus(id_menus);
menus.setNombre_menus(nombre_menus);
menus.setCodigo_menus(codigo_menus);

if(MenusControlador.modificar(menus)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>