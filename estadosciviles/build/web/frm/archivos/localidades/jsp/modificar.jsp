<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.LocalidadesControlador"%>
<%@page import="jsppostgres.modelos.Localidades"%>
<%

int id_localidades= Integer.parseInt(request.getParameter("id_localidades"));
String nombre_localidades = request.getParameter("nombre_localidades");

String tipo="error";
String mensaje= "Datos no modificados";

Localidades localidades= new Localidades();
localidades.setId_localidades(id_localidades);
localidades.setNombre_localidades(nombre_localidades);

if(LocalidadesControlador.modificar(localidades)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>