<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.EstadosCivilesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.EstadosCiviles"%>
<%

int id_estadocivil= Integer.parseInt(request.getParameter("id_estadocivil"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

EstadosCiviles estadocivil= EstadosCivilesControlador.buscarId(id_estadocivil);
if (estadocivil != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    estadocivil= new EstadosCiviles();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_estadocivil", estadocivil.getId_estadocivil());
obj.put("nombre_estadocivil", estadocivil.getNombre_estadocivil());

out.print(obj);
out.flush();
%>
