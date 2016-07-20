<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.EstadosCivilesControlador"%>
<%@page import="jsppostgres.modelos.EstadosCiviles"%>
<%

int id_estadocivil= Integer.parseInt(request.getParameter("id_estadocivil"));


String tipo="error";
String mensaje= "Datos no eliminados";

EstadosCiviles estadocivil= new EstadosCiviles();
estadocivil.setId_estadocivil(id_estadocivil);

if(EstadosCivilesControlador.eliminar(estadocivil)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
