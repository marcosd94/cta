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
public class Roles {
    
    private int id_roles;
    private String nombre_roles;

    public Roles(int id_roles, String nombre_roles) {
        this.id_roles = id_roles;
        this.nombre_roles = nombre_roles;
    }

    public Roles() {
    }

    public int getId_roles() {
        return id_roles;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
    }

    public String getNombre_roles() {
        return nombre_roles;
    }

    public void setNombre_roles(String nombre_roles) {
        this.nombre_roles = nombre_roles;
    }
}
