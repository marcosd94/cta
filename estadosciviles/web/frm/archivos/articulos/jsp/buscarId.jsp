<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.ArticulosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Articulos"%>
<%

int id_articulos= Integer.parseInt(request.getParameter("id_articulos"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Articulos articulos= ArticulosControlador.buscarId(id_articulos);
if (articulos != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    articulos= new Articulos();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_articulos", articulos.getId_articulos());
obj.put("nombre_articulos", articulos.getNombre_articulos());
obj.put("codigo_articulos", articulos.getCodigo_articulos());
obj.put("serie_articulos", articulos.getSerie_articulos());
obj.put("id_rubros", articulos.getRubro().getId_rubros());
obj.put("nombre_rubros", articulos.getRubro().getNombre_rubros());

out.print(obj);
out.flush();
%>
