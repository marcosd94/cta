/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Permisos;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class PermisosControlador {

    public static boolean agregar(Permisos permisos) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into permisos "
                    + "(nombre_permisos)"
                    + "values(?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, permisos.getNombre_permisos());
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

    public static Permisos buscarId(int id) {
        Permisos permisos = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from permisos where id_permisos=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        permisos = new Permisos();
                        permisos.setId_permisos(rs.getInt("id_permisos"));
                        permisos.setNombre_permisos(rs.getString("nombre_permisos"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return permisos;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from permisos where upper(nombre_permisos) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_permisos "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_permisos")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_permisos")+"</td>";
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
    
    public static boolean modificar(Permisos permisos) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update permisos set nombre_permisos = ? "
                    + "where id_permisos = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, permisos.getNombre_permisos());
                ps.setInt(2, permisos.getId_permisos());
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
        
    public static boolean eliminar(Permisos permisos) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from permisos where id_permisos = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, permisos.getId_permisos());
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
