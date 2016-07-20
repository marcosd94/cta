<%-- 
    Document   : buscarNombre
    Created on : Jul 6, 2016, 11:33:51 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.ArticulosControlador"%>
<%
    String nombre_articulos = request.getParameter("bnombre_articulos");
    String codigo_articulos = request.getParameter("codigo_articulos");
    String serie_articulos = request.getParameter("serie_articulos");
    //int pagina =1;
    int pagina= Integer.parseInt(request.getParameter("bpagina"));

    String mensaje= "Datos encontrados";

    String contenido= ArticulosControlador.buscarNombre(nombre_articulos,pagina);
    JSONObject obj = new JSONObject();
    obj.put("mensaje", mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>