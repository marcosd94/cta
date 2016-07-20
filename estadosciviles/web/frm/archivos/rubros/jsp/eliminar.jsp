<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.RubrosControlador"%>
<%@page import="jsppostgres.modelos.Rubros"%>
<%

int id_rubros= Integer.parseInt(request.getParameter("id_rubros"));


String tipo="error";
String mensaje= "Datos no eliminados";

Rubros rubros= new Rubros();
rubros.setId_rubros(id_rubros);

if(RubrosControlador.eliminar(rubros)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
