<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.FormulariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Formularios"%>
<%

int id_formularios= Integer.parseInt(request.getParameter("id_formularios"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Formularios formularios= FormulariosControlador.buscarId(id_formularios);
if (formularios != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    formularios= new Formularios();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_formularios", formularios.getId_formularios());
obj.put("nombre_formularios", formularios.getNombre_formularios());
obj.put("codigo_formularios", formularios.getCodigo_formularios());
obj.put("id_menus", formularios.getMenu().getId_menus());
obj.put("nombre_menus", formularios.getMenu().getNombre_menus());

out.print(obj);
out.flush();
%>
