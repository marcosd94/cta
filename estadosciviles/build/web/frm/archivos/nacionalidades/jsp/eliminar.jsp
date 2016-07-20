<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.ProfesionesControlador"%>
<%@page import="jsppostgres.modelos.Profesiones"%>
<%

int id_profesiones= Integer.parseInt(request.getParameter("id_profesiones"));


String tipo="error";
String mensaje= "Datos no eliminados";

Profesiones profesiones= new Profesiones();
profesiones.setId_profesiones(id_profesiones);

if(ProfesionesControlador.eliminar(profesiones)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
