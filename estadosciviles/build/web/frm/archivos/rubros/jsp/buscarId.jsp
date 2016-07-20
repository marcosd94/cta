<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.RubrosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Rubros"%>
<%

int id_rubros= Integer.parseInt(request.getParameter("id_rubros"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Rubros rubros= RubrosControlador.buscarId(id_rubros);
if (rubros != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    rubros= new Rubros();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_rubros", rubros.getId_rubros());
obj.put("nombre_rubros", rubros.getNombre_rubros());

out.print(obj);
out.flush();
%>
