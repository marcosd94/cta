/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Nacionalidades;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class NacionalidadesControlador {
    public static boolean agregar(Nacionalidades nacionalidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into nacionalidades "
                    + "(nombre_nacionalidades)"
                    + "values(?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, nacionalidad.getNombre_nacionalidades());
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

    public static Nacionalidades buscarId(int id) {
        Nacionalidades nacionalidades = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from nacionalidades where id_nacionalidades=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        nacionalidades = new Nacionalidades();
                        nacionalidades.setId_nacionalidades(rs.getInt("id_nacionalidades"));
                        nacionalidades.setNombre_nacionalidades(rs.getString("nombre_nacionalidades"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return nacionalidades;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from nacionalidades where upper(nombre_nacionalidades) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_nacionalidades "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_nacionalidades")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_nacionalidades")+"</td>";
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
    
    public static boolean modificar(Nacionalidades nacionalidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update nacionalidades set nombre_nacionalidades = ? "
                    + "where id_nacionalidades = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, nacionalidad.getNombre_nacionalidades());
                ps.setInt(2, nacionalidad.getId_nacionalidades());
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
        
    public static boolean eliminar(Nacionalidades nacionalidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from nacionalidades where id_nacionalidades = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, nacionalidad.getId_nacionalidades());
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
