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
public class Profesiones {
    private int id_profesiones;
    private String nombre_profesiones;

    public Profesiones(int id_profesiones, String nombre_profesiones) {
        this.id_profesiones = id_profesiones;
        this.nombre_profesiones = nombre_profesiones;
    }

    public Profesiones() {
    }

    public int getId_profesiones() {
        return id_profesiones;
    }

    public void setId_profesiones(int id_profesiones) {
        this.id_profesiones = id_profesiones;
    }

    public String getNombre_profesiones() {
        return nombre_profesiones;
    }

    public void setNombre_profesiones(String nombre_profesiones) {
        this.nombre_profesiones = nombre_profesiones;
    }
}
