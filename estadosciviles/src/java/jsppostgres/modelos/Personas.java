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
public class Personas {
    
    private int id_personas;
    private String nombre_personas;

    public Personas(int id_personas, String nombre_personas) {
        this.id_personas = id_personas;
        this.nombre_personas = nombre_personas;
    }

    public Personas() {
    }

    public int getId_personas() {
        return id_personas;
    }

    public void setId_personas(int id_personas) {
        this.id_personas = id_personas;
    }

    public String getNombre_personas() {
        return nombre_personas;
    }

    public void setNombre_personas(String nombre_personas) {
        this.nombre_personas = nombre_personas;
    }
}
