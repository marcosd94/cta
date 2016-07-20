/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Formularios;
import jsppostgres.modelos.Menus;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class FormulariosControlador {

    public static boolean agregar(Formularios formularios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into formularios "
                    + "(nombre_formularios,codigo_formularios,id_menus)"
                    + "values(?,?,?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, formularios.getNombre_formularios());
                ps.setString(2, formularios.getCodigo_formularios());
                ps.setInt(3, formularios.getMenu().getId_menus());
                ps.executeUpdate();
                ps.close();
                Conexion.getCon().commit();
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
                try {
                    Conexion.getCon().rollback();
                } catch (SQLException ex1) {
                    System.out.println("-->" + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static Formularios buscarId(int id) {
        Formularios formularios = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from formularios f"
                        + " left join menus m on m.id_menus = f.id_menus where id_formularios=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        formularios = new Formularios();
                        formularios.setId_formularios(rs.getInt("id_formularios"));
                        formularios.setNombre_formularios(rs.getString("nombre_formularios"));
                        formularios.setCodigo_formularios(rs.getString("codigo_formularios"));
                        Menus menu = new Menus();
                        menu.setId_menus(rs.getInt("id_menus"));
                        menu.setNombre_menus(rs.getString("nombre_menus"));
                        menu.setCodigo_menus(rs.getString("codigo_menus"));
                        formularios.setMenu(menu);
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return formularios;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from formularios where upper(nombre_formularios) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_formularios "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_formularios")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_formularios")+"</td>";
                        tabla +="<td>"+rs.getString("codigo_formularios")+"</td>";
                        tabla +="<td>"+rs.getString("id_menus")+"</td>";
                        tabla +="</tr>";
                    }
                    if(tabla.equals("")){
                        tabla= "<tr><td colspan=2>No existen registros..</tr></td>";
                    }
                    ps.close();
                    valor=tabla;
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return valor;
    }
    
    public static boolean modificar(Formularios formularios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update formularios set nombre_formularios = ?, codigo_formularios =? , id_menus=? "
                    + "where id_formularios = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, formularios.getNombre_formularios());
                ps.setString(2, formularios.getCodigo_formularios());
                ps.setInt(3, formularios.getMenu().getId_menus());
                ps.setInt(4, formularios.getId_formularios());
                ps.executeUpdate();
                ps.close();
                Conexion.getCon().commit();
                System.out.println(ps);
                System.out.println("--> Grabado");
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
                try {
                    Conexion.getCon().rollback();
                } catch (SQLException ex1) {
                    System.out.println("-->" + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }
        
    public static boolean eliminar(Formularios formularios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from formularios where id_formularios = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, formularios.getId_formularios());
                ps.executeUpdate();
                ps.close();
                Conexion.getCon().commit();
                valor = true;
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
                try {
                    Conexion.getCon().rollback();
                } catch (SQLException ex1) {
                    System.out.println("-->" + ex1.getLocalizedMessage());
                }
            }
        }
        Conexion.cerrar();
        return valor;
    }
}
