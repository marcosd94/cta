<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.UsuariosControlador"%>
<%@page import="jsppostgres.modelos.Usuarios"%>
<%

int id_usuarios= Integer.parseInt(request.getParameter("id_usuarios"));
String nombre_usuarios = request.getParameter("nombre_usuarios");
String usuario_usuarios = request.getParameter("usuario_usuarios");
String clave_usuarios = request.getParameter("clave_usuarios");

String tipo="error";
String mensaje= "Datos no modificados";

Usuarios usuarios= new Usuarios();
usuarios.setId_usuarios(id_usuarios);
usuarios.setNombre_usuarios(nombre_usuarios);
usuarios.setUsuario_usuarios(usuario_usuarios);
usuarios.setClave_usuarios(clave_usuarios);

if(UsuariosControlador.modificar(usuarios)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>