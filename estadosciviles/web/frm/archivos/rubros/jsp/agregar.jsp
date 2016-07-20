<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.RubrosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Rubros"%>
<%
int id_rubros= Integer.parseInt(request.getParameter("id_rubros"));
String nombre_rubros = request.getParameter("nombre_rubros");


String tipo="error";
String mensaje= "Datos no Agregados";

Rubros rubros= new Rubros();
rubros.setId_rubros(id_rubros);
rubros.setNombre_rubros(nombre_rubros);

if(RubrosControlador.agregar(rubros)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>