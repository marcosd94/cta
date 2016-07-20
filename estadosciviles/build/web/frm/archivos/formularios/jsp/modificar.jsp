<%-- 
    Document   : modificar
    Created on : Jul 6, 2016, 9:37:07 AM
    Author     : Administrator
--%>


<%@page import="jsppostgres.modelos.Menus"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jsppostgres.controladores.FormulariosControlador"%>
<%@page import="jsppostgres.modelos.Formularios"%>
<%

    int id_formularios = Integer.parseInt(request.getParameter("id_formularios"));
    String nombre_formularios = request.getParameter("nombre_formularios");
    String codigo_formularios = request.getParameter("codigo_formularios");
    int id_menus = Integer.parseInt(request.getParameter("id_menus"));
    String nombre_menus = request.getParameter("nombre_menus");

    String tipo = "error";
    String mensaje = "Datos no modificados";

    Formularios formularios = new Formularios();
    formularios.setId_formularios(id_formularios);
    formularios.setNombre_formularios(nombre_formularios);
    formularios.setCodigo_formularios(codigo_formularios);
    Menus menu = new Menus();
    menu.setId_menus(id_menus);
    menu.setNombre_menus(nombre_menus);
    formularios.setMenu(menu);

    if (FormulariosControlador.modificar(formularios)) {
        tipo = "success";
        mensaje = "Datos modificados";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);

    out.print(obj);
    out.flush();
%>