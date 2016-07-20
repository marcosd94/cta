<%-- 
    Document   : buscarId
    Created on : Jul 6, 2016, 8:54:00 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Usuarios"%>
<%

int id_usuarios= Integer.parseInt(request.getParameter("id_usuarios"));

String tipo="error";
String mensaje= "Datos no encontrados";
String nuevo = "true";

Usuarios usuarios= UsuariosControlador.buscarId(id_usuarios);
if (usuarios != null){
    tipo="success";
    mensaje= "Datos encontrados";
    nuevo = "false";
}else{
    usuarios= new Usuarios();
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
obj.put("nuevo",nuevo);
obj.put("id_usuarios", usuarios.getId_usuarios());
obj.put("nombre_usuarios", usuarios.getNombre_usuarios());

out.print(obj);
out.flush();
%>
