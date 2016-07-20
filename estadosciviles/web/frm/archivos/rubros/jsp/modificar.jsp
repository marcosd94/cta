<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.RubrosControlador"%>
<%@page import="jsppostgres.modelos.Rubros"%>
<%

int id_rubros= Integer.parseInt(request.getParameter("id_rubros"));
String nombre_rubros = request.getParameter("nombre_rubros");

String tipo="error";
String mensaje= "Datos no modificados";

Rubros rubros= new Rubros();
rubros.setId_rubros(id_rubros);
rubros.setNombre_rubros(nombre_rubros);

if(RubrosControlador.modificar(rubros)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>