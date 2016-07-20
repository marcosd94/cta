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
public class Formularios {
    
    private int id_formularios;
    private String nombre_formularios;
    private String codigo_formularios;
    private Menus menu;

    public Formularios() {
    }

    public Formularios(int id_formularios, String nombre_formularios, String codigo_formularios, Menus menu) {
        this.id_formularios = id_formularios;
        this.nombre_formularios = nombre_formularios;
        this.codigo_formularios = codigo_formularios;
        this.menu = menu;
    }

    public int getId_formularios() {
        return id_formularios;
    }

    public void setId_formularios(int id_formularios) {
        this.id_formularios = id_formularios;
    }

    public String getNombre_formularios() {
        return nombre_formularios;
    }

    public void setNombre_formularios(String nombre_formularios) {
        this.nombre_formularios = nombre_formularios;
    }

    public String getCodigo_formularios() {
        return codigo_formularios;
    }

    public void setCodigo_formularios(String codigo_formularios) {
        this.codigo_formularios = codigo_formularios;
    }

    public Menus getMenu() {
        return menu;
    }

    public void setMenu(Menus menu) {
        this.menu = menu;
    }

}
