<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.LocalidadesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Localidades"%>
<%

int id_localidades= Integer.parseInt(request.getParameter("id_localidades"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Localidades localidades= LocalidadesControlador.buscarId(id_localidades);
if (localidades != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    localidades= new Localidades();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_localidades", localidades.getId_localidades());
obj.put("nombre_localidades", localidades.getNombre_localidades());

out.print(obj);
out.flush();
%>
