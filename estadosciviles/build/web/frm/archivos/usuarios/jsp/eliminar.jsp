<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.UsuariosControlador"%>
<%@page import="jsppostgres.modelos.Usuarios"%>
<%

int id_usuarios= Integer.parseInt(request.getParameter("id_usuarios"));


String tipo="error";
String mensaje= "Datos no eliminados";

Usuarios usuarios= new Usuarios();
usuarios.setId_usuarios(id_usuarios);

if(UsuariosControlador.eliminar(usuarios)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
