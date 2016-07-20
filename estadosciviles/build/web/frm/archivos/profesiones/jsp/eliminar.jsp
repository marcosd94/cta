<%-- 
    Document   : eliminar
    Created on : Jul 6, 2016, 9:51:47 AM
    Author     : Administrator
--%>

<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.NacionalidadesControlador"%>
<%@page import="jsppostgres.modelos.Nacionalidades"%>
<%

int id_nacionalidades= Integer.parseInt(request.getParameter("id_nacionalidades"));


String tipo="error";
String mensaje= "Datos no eliminados";

Nacionalidades nacionalidades= new Nacionalidades();
nacionalidades.setId_nacionalidades(id_nacionalidades);

if(NacionalidadesControlador.eliminar(nacionalidades)){
    tipo="success";
    mensaje= "Datos eliminados";
}
JSONObject obj = new JSONObject();
obj.put("tipo",tipo);
obj.put("mensaje", mensaje);
out.print(obj);
out.flush();
%>
