<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.ProfesionesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Profesiones"%>
<%
int id_profesiones= Integer.parseInt(request.getParameter("id_profesiones"));
String nombre_profesiones = request.getParameter("nombre_profesiones");


String tipo="error";
String mensaje= "Datos no Agregados";

Profesiones profesiones= new Profesiones();
profesiones.setId_profesiones(id_profesiones);
profesiones.setNombre_profesiones(nombre_profesiones);

if(ProfesionesControlador.agregar(profesiones)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>