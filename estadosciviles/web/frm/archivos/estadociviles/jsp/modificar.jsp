<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.EstadosCivilesControlador"%>
<%@page import="jsppostgres.modelos.EstadosCiviles"%>
<%

int id_estadocivil= Integer.parseInt(request.getParameter("id_estadocivil"));
String nombre_estadocivil = request.getParameter("nombre_estadocivil");

String tipo="error";
String mensaje= "Datos no modificados";

EstadosCiviles estadocivil= new EstadosCiviles();
estadocivil.setId_estadocivil(id_estadocivil);
estadocivil.setNombre_estadocivil(nombre_estadocivil);

if(EstadosCivilesControlador.modificar(estadocivil)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>