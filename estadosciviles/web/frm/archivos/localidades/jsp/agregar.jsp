<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.LocalidadesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Localidades"%>
<%
int id_localidades= Integer.parseInt(request.getParameter("id_localidades"));
String nombre_localidades = request.getParameter("nombre_localidades");


String tipo="error";
String mensaje= "Datos no Agregados";

Localidades localidades= new Localidades();
localidades.setId_localidades(id_localidades);
localidades.setNombre_localidades(nombre_localidades);

if(LocalidadesControlador.agregar(localidades)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>