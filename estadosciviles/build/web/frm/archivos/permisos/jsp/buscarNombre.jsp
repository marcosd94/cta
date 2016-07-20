<%-- 
    Document   : buscarNombre
    Created on : Jul 6, 2016, 11:33:51 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.PermisosControlador"%>
<%
    String nombre_permisos = request.getParameter("bnombre_permisos");
    //int pagina =1;
    int pagina= Integer.parseInt(request.getParameter("bpagina"));

    String mensaje= "Datos encontrados";

    String contenido= PermisosControlador.buscarNombre(nombre_permisos,pagina);
    JSONObject obj = new JSONObject();
    obj.put("mensaje", mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>