/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Usuarios;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class UsuariosControlador {

    public static boolean agregar(Usuarios usuarios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into usuarios "
                    + "(nombre_usuarios,usuario_usuarios,clave_usuarios)"
                    + "values(?,?,?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, usuarios.getNombre_usuarios());
                ps.setString(2, usuarios.getUsuario_usuarios());
                ps.setString(3, usuarios.getClave_usuarios());
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

    public static Usuarios buscarId(int id) {
        Usuarios usuarios = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from usuarios where id_usuarios=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        usuarios = new Usuarios();
                        usuarios.setId_usuarios(rs.getInt("id_usuarios"));
                        usuarios.setNombre_usuarios(rs.getString("nombre_usuarios"));
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return usuarios;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from usuarios where upper(nombre_usuarios) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_usuarios "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_usuarios")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_usuarios")+"</td>";
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
    
    public static boolean modificar(Usuarios usuarios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update usuarios set nombre_usuarios = ? , usuario_usuarios=? , clave_usuarios = ? "
                    + "where id_usuarios = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, usuarios.getNombre_usuarios());
                ps.setString(2, usuarios.getUsuario_usuarios());
                ps.setString(3, usuarios.getClave_usuarios());
                ps.setInt(4, usuarios.getId_usuarios());
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
        
    public static boolean eliminar(Usuarios usuarios) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from usuarios where id_usuarios = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, usuarios.getId_usuarios());
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
