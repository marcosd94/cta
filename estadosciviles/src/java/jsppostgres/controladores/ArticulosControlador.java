/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsppostgres.modelos.Articulos;
import jsppostgres.modelos.Rubros;
import jsppostgres.utiles.Conexion;
import jsppostgres.utiles.Utiles;

/**
 *
 * @author Administrator
 */
public class ArticulosControlador {

    public static boolean agregar(Articulos articulo) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into articulos "
                    + "(nombre_articulos,codigo_articulos,serie_articulos,id_rubros)"
                    + "values(?,?,?,?)";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, articulo.getNombre_articulos());
                ps.setString(2, articulo.getCodigo_articulos());
                ps.setString(3, articulo.getSerie_articulos());
                ps.setInt(4, articulo.getRubro().getId_rubros());
                ps.executeUpdate();
                ps.close();
                Conexion.getCon().commit();
                valor = true;
                System.out.println(ps);
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

    public static Articulos buscarId(int id) {
        Articulos articulos = null;
        if (Conexion.conectar()) {
            try {
                String sql = "select * from articulos a "
                        + " left join rubros r on r.id_rubros=a.id_rubros where id_articulos=?";
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        articulos = new Articulos();
                        articulos.setId_articulos(rs.getInt("id_articulos"));
                        articulos.setNombre_articulos(rs.getString("nombre_articulos"));
                        articulos.setCodigo_articulos(rs.getString("codigo_articulos"));
                        articulos.setSerie_articulos(rs.getString("serie_articulos"));
                        Rubros rubro = new Rubros();
                        rubro.setId_rubros(rs.getInt("id_rubros"));
                        rubro.setNombre_rubros(rs.getString("nombre_rubros"));
                        articulos.setRubro(rubro);
                    }
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println("--> " + ex.getLocalizedMessage());
            }
        }
        Conexion.cerrar();
        return articulos;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset =(pagina-1)*Utiles.REGISTROS_PAGINA;
        String valor="";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from articulos where upper(nombre_articulos) like '%"+
                        nombre.toUpperCase()+
                        "%'"+
                        " order by id_articulos "+
                        " offset " + offset + " limit " +Utiles.REGISTROS_PAGINA;
                System.out.println("-->" + sql);
                try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla="";
                    while (rs.next()) {
                        tabla +="<tr>";
                        tabla +="<td>"+rs.getString("id_articulos")+"</td>";
                        tabla +="<td>"+rs.getString("nombre_articulos")+"</td>";
                        tabla +="<td>"+rs.getString("codigo_articulos")+"</td>";
                        tabla +="<td>"+rs.getString("serie_articulos")+"</td>";
                        tabla +="<td>"+rs.getString("id_rubros")+"</td>";
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
    
    public static boolean modificar(Articulos articulo) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update articulos set nombre_articulos = ?,codigo_articulos = ?"
                    + ",serie_articulos  = ?,id_rubros  = ? "
                    + "where id_articulos = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setString(1, articulo.getNombre_articulos());
                ps.setString(2, articulo.getCodigo_articulos());
                ps.setString(3, articulo.getSerie_articulos());
                ps.setInt(4, articulo.getRubro().getId_rubros());
                ps.setInt(5, articulo.getId_articulos());
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
        
    public static boolean eliminar(Articulos articulo) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from articulos where id_articulos = ?";
            try (PreparedStatement ps = Conexion.getCon().prepareStatement(sql)) {
                ps.setInt(1, articulo.getId_articulos());
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
