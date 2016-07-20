<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.ProfesionesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Profesiones"%>
<%

int id_profesiones= Integer.parseInt(request.getParameter("id_profesiones"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Profesiones profesiones= ProfesionesControlador.buscarId(id_profesiones);
if (profesiones != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    profesiones= new Profesiones();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_profesiones", profesiones.getId_profesiones());
obj.put("nombre_profesiones", profesiones.getNombre_profesiones());

out.print(obj);
out.flush();
%>
