<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.NacionalidadesControlador"%>
<%@page import="jsppostgres.modelos.Nacionalidades"%>
<%

int id_nacionalidades= Integer.parseInt(request.getParameter("id_nacionalidades"));
String nombre_nacionalidades = request.getParameter("nombre_nacionalidades");

String tipo="error";
String mensaje= "Datos no modificados";

Nacionalidades nacionalidades= new Nacionalidades();
nacionalidades.setId_nacionalidades(id_nacionalidades);
nacionalidades.setNombre_nacionalidades(nombre_nacionalidades);

if(NacionalidadesControlador.modificar(nacionalidades)){
    tipo="success";
    mensaje= "Datos modificados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);

out.print(obj);
out.flush();
%>