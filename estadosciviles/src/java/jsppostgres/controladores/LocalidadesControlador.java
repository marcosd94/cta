/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Localidades;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class LocalidadesControlador {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    public static boolean agregar(Localidades localidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into localidades "
                    + "(nombre_localidades)"
                    + "values(?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, localidad.getNombre_localidades());
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

    public static Localidades buscarId(int id) {
        Localidades localidades = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from localidades where id_localidades=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        localidades = new Localidades();
                        localidades.setId_localidades(rs.getInt("id_localidades"));
                        localidades.setNombre_localidades(rs.getString("nombre_localidades"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return localidades;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from localidades where upper(nombre_localidades) like '%"
                        + nombre.toUpperCase()
                        + "%'"
                        + " order by id_localidades "
                        + " offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>";
                        tabla += "<td>" + rs.getString("id_localidades") + "</td>";
                        tabla += "<td>" + rs.getString("nombre_localidades") + "</td>";
                        tabla += "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros..</tr></td>";
                    }
                    ps.close();
                    valor = tabla;
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static boolean modificar(Localidades localidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update localidades set nombre_localidades = ? "
                    + "where id_localidades = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, localidad.getNombre_localidades());
                ps.setInt(2, localidad.getId_localidades());
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

    public static boolean eliminar(Localidades localidad) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from localidades where id_localidades = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, localidad.getId_localidades());
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
