<%-- 
    Document   : buscarNombre
    Created on : Jul 6, 2016, 11:33:51 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.UsuariosControlador"%>
<%
    String nombre_usuarios = request.getParameter("bnombre_usuarios");
    //int pagina =1;
    int pagina= Integer.parseInt(request.getParameter("bpagina"));

    String mensaje= "Datos encontrados";

    String contenido= UsuariosControlador.buscarNombre(nombre_usuarios,pagina);
    JSONObject obj = new JSONObject();
    obj.put("mensaje", mensaje);
    obj.put("contenido", contenido);
    
    out.print(obj);
    out.flush();
%>