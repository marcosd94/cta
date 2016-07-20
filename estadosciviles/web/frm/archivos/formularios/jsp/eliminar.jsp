<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.FormulariosControlador"%>
<%@page import="jsppostgres.modelos.Formularios"%>
<%

int id_formularios= Integer.parseInt(request.getParameter("id_formularios"));


String tipo="error";
String mensaje= "Datos no eliminados";

Formularios formularios= new Formularios();
formularios.setId_formularios(id_formularios);

if(FormulariosControlador.eliminar(formularios)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
