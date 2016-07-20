<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.EstadosCivilesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.EstadosCiviles"%>
<%
int id_estadocivil= Integer.parseInt(request.getParameter("id_estadocivil"));
String nombre_estadocivil = request.getParameter("nombre_estadocivil");


String tipo="error";
String mensaje= "Datos no Agregados";

EstadosCiviles estadocivil= new EstadosCiviles();
estadocivil.setId_estadocivil(id_estadocivil);
estadocivil.setNombre_estadocivil(nombre_estadocivil);

if(EstadosCivilesControlador.agregar(estadocivil)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>