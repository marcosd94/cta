<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.UsuariosControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Usuarios"%>
<%
int id_usuarios= Integer.parseInt(request.getParameter("id_usuarios"));
String nombre_usuarios = request.getParameter("nombre_usuarios");
String usuario_usuarios = request.getParameter("usuario_usuarios");
String clave_usuarios = request.getParameter("clave_usuarios");


String tipo="error";
String mensaje= "Datos no Agregados";

Usuarios usuarios= new Usuarios();
usuarios.setId_usuarios(id_usuarios);
usuarios.setNombre_usuarios(nombre_usuarios);
usuarios.setUsuario_usuarios(usuario_usuarios);
usuarios.setClave_usuarios(clave_usuarios);

if(UsuariosControlador.agregar(usuarios)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>