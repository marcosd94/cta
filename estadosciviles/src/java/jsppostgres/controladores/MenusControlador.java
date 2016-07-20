/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Menus;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class MenusControlador {

    public static boolean agregar(Menus menus) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into menus "
                    + "(nombre_menus,codigo_menus)"
                    + "values(?,?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, menus.getNombre_menus());
                ps.setString(2, menus.getCodigo_menus());
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

    public static Menus buscarId(int id) {
        Menus menus = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from menus where id_menus=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        menus = new Menus();
                        menus.setId_menus(rs.getInt("id_menus"));
                        menus.setNombre_menus(rs.getString("nombre_menus"));
                        menus.setCodigo_menus(rs.getString("codigo_menus"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return menus;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from menus where upper(nombre_menus) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_menus "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_menus")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_menus")+"</td>";
                        tabla +="<td>"+rs.getString("codigo_menus")+"</td>";
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
    
    public static boolean modificar(Menus menus) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update menus set nombre_menus = ?,codigo_menus=? "
                    + "where id_menus = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, menus.getNombre_menus());
                ps.setString(2, menus.getCodigo_menus());
                ps.setInt(3, menus.getId_menus());
                ps.executeUpdate();
                ps.close();
                Conexion.getCon().commit();
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
        
    public static boolean eliminar(Menus menus) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from menus where id_menus = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, menus.getId_menus());
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
