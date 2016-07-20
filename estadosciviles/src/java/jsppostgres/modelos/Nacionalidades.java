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
public class Nacionalidades {
    private int id_nacionalidades;
    private String nombre_nacionalidades;

    public Nacionalidades(int id_nacionalidades, String nombre_nacionalidades) {
        this.id_nacionalidades = id_nacionalidades;
        this.nombre_nacionalidades = nombre_nacionalidades;
    }

    public Nacionalidades() {
    }

    public int getId_nacionalidades() {
        return id_nacionalidades;
    }

    public void setId_nacionalidades(int id_nacionalidades) {
        this.id_nacionalidades = id_nacionalidades;
    }

    public String getNombre_nacionalidades() {
        return nombre_nacionalidades;
    }

    public void setNombre_nacionalidades(String nombre_nacionalidades) {
        this.nombre_nacionalidades = nombre_nacionalidades;
    }
}
