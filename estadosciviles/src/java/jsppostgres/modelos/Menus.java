/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.modelos;

/**
 *
 * @author Administrator
 */
public class Menus {
    
    private int id_menus;
    private String nombre_menus;
    private String codigo_menus;

    public Menus() {
    }

    public Menus(int id_menus, String nombre_menus, String codigo_menus) {
        this.id_menus = id_menus;
        this.nombre_menus = nombre_menus;
        this.codigo_menus = codigo_menus;
    }

    public String getCodigo_menus() {
        return codigo_menus;
    }

    public void setCodigo_menus(String codigo_menus) {
        this.codigo_menus = codigo_menus;
    }

    public int getId_menus() {
        return id_menus;
    }

    public void setId_menus(int id_menus) {
        this.id_menus = id_menus;
    }

    public String getNombre_menus() {
        return nombre_menus;
    }

    public void setNombre_menus(String nombre_menus) {
        this.nombre_menus = nombre_menus;
    }
}
