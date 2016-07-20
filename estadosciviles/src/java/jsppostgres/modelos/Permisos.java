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
public class Permisos {
    
    private int id_permisos;
    private String nombre_permisos;

    public Permisos(int id_permisos, String nombre_permisos) {
        this.id_permisos = id_permisos;
        this.nombre_permisos = nombre_permisos;
    }

    public Permisos() {
    }

    public int getId_permisos() {
        return id_permisos;
    }

    public void setId_permisos(int id_permisos) {
        this.id_permisos = id_permisos;
    }

    public String getNombre_permisos() {
        return nombre_permisos;
    }

    public void setNombre_permisos(String nombre_permisos) {
        this.nombre_permisos = nombre_permisos;
    }
}
