<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.NacionalidadesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Nacionalidades"%>
<%

int id_nacionalidades= Integer.parseInt(request.getParameter("id_nacionalidades"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Nacionalidades nacionalidades= NacionalidadesControlador.buscarId(id_nacionalidades);
if (nacionalidades != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    nacionalidades= new Nacionalidades();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_nacionalidades", nacionalidades.getId_nacionalidades());
obj.put("nombre_nacionalidades", nacionalidades.getNombre_nacionalidades());

out.print(obj);
out.flush();
%>
