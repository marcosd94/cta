<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.modelos.Rubros"%>
<%@page import="jsppostgres.controladores.ArticulosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Articulos"%>
<%
int id_articulos= Integer.parseInt(request.getParameter("id_articulos"));
String nombre_articulos = request.getParameter("nombre_articulos");
String codigo_articulos = request.getParameter("codigo_articulos");
String serie_articulos = request.getParameter("serie_articulos");
int id_rubros = Integer.parseInt(request.getParameter("id_rubros"));
String nombre_rubros = request.getParameter("nombre_rubros");


String tipo="error";
String mensaje= "Datos no Agregados";

Articulos articulos= new Articulos();
articulos.setId_articulos(id_articulos);
articulos.setNombre_articulos(nombre_articulos);
articulos.setCodigo_articulos(codigo_articulos);
articulos.setSerie_articulos(serie_articulos);
Rubros rubro = new Rubros();
rubro.setId_rubros(id_rubros);
rubro.setNombre_rubros(nombre_rubros);
articulos.setRubro(rubro);

if(ArticulosControlador.agregar(articulos)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>