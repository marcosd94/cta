<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.ArticulosControlador"%>
<%@page import="jsppostgres.modelos.Articulos"%>
<%

int id_articulos= Integer.parseInt(request.getParameter("id_articulos"));


String tipo="error";
String mensaje= "Datos no eliminados";

Articulos articulos= new Articulos();
articulos.setId_articulos(id_articulos);

if(ArticulosControlador.eliminar(articulos)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
