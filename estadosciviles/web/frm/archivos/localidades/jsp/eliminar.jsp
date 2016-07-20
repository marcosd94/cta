<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.LocalidadesControlador"%>
<%@page import="jsppostgres.modelos.Localidades"%>
<%

int id_localidades= Integer.parseInt(request.getParameter("id_localidades"));


String tipo="error";
String mensaje= "Datos no eliminados";

Localidades localidades= new Localidades();
localidades.setId_localidades(id_localidades);

if(LocalidadesControlador.eliminar(localidades)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
