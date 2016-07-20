<%-- 
    Document   : agregar
    Created on : Jul 1, 2016, 9:50:21 AM
    Author     : Administrator
--%>

<%@page import="jsppostgres.controladores.NacionalidadesControlador"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.modelos.Nacionalidades"%>
<%
int id_nacionalidades= Integer.parseInt(request.getParameter("id_nacionalidades"));
String nombre_nacionalidades = request.getParameter("nombre_nacionalidades");


String tipo="error";
String mensaje= "Datos no Agregados";

Nacionalidades nacionalidades= new Nacionalidades();
nacionalidades.setId_nacionalidades(id_nacionalidades);
nacionalidades.setNombre_nacionalidades(nombre_nacionalidades);

if(NacionalidadesControlador.agregar(nacionalidades)){
    tipo="success";
    mensaje= "Datos agregados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>