<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.MenusControlador"%>
<%@page import="jsppostgres.modelos.Menus"%>
<%

int id_menus= Integer.parseInt(request.getParameter("id_menus"));


String tipo="error";
String mensaje= "Datos no eliminados";

Menus menus= new Menus();
menus.setId_menus(id_menus);

if(MenusControlador.eliminar(menus)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
