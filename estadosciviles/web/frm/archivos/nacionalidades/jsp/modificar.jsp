<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.ProfesionesControlador"%>
<%@page import="jsppostgres.modelos.Profesiones"%>
<%

int id_profesiones= Integer.parseInt(request.getParameter("id_profesiones"));
String nombre_profesiones = request.getParameter("nombre_profesiones");

String tipo="error";
String mensaje= "Datos no modificados";

Profesiones profesiones= new Profesiones();
profesiones.setId_profesiones(id_profesiones);
profesiones.setNombre_profesiones(nombre_profesiones);

if(ProfesionesControlador.modificar(profesiones)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>