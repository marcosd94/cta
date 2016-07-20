/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Profesiones;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class ProfesionesControlador {
    

    public static boolean agregar(Profesiones profesion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into profesiones "
                    + "(nombre_profesiones)"
                    + "values(?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, profesion.getNombre_profesiones());
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

    public static Profesiones buscarId(int id) {
        Profesiones profesiones = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from profesiones where id_profesiones=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        profesiones = new Profesiones();
                        profesiones.setId_profesiones(rs.getInt("id_profesiones"));
                        profesiones.setNombre_profesiones(rs.getString("nombre_profesiones"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return profesiones;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from profesiones where upper(nombre_profesiones) like '%"
                        + nombre.toUpperCase()
                        + "%'"
                        + " order by id_profesiones "
                        + " offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>";
                        tabla += "<td>" + rs.getString("id_profesiones") + "</td>";
                        tabla += "<td>" + rs.getString("nombre_profesiones") + "</td>";
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

    public static boolean modificar(Profesiones profesion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update profesiones set nombre_profesiones = ? "
                    + "where id_profesiones = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, profesion.getNombre_profesiones());
                ps.setInt(2, profesion.getId_profesiones());
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

    public static boolean eliminar(Profesiones profesion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from profesiones where id_profesiones = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, profesion.getId_profesiones());
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
