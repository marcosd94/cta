<%-- 
    Document   : buscarNombre
    Created on : Jul 6, 2016, 11:33:51 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.NacionalidadesControlador"%>
<%
    String nombre_nacionalidades = request.getParameter("bnombre_nacionalidades");
    //int pagina =1;
    int pagina= Integer.parseInt(request.getParameter("bpagina"));

    String mensaje= "Datos encontrados";

    String contenido= NacionalidadesControlador.buscarNombre(nombre_nacionalidades,pagina);
    JSONObject obj = new JSONObject();
    obj.put("mensaje", mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>