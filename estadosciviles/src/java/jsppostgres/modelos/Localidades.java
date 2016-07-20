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
public class Localidades {
    private int id_localidades;
    private String nombre_localidades;

    public Localidades(int id_localidades, String nombre_localidades) {
        this.id_localidades = id_localidades;
        this.nombre_localidades = nombre_localidades;
    }

    public Localidades() {
    }

    public int getId_localidades() {
        return id_localidades;
    }

    public void setId_localidades(int id_localidades) {
        this.id_localidades = id_localidades;
    }

    public String getNombre_localidades() {
        return nombre_localidades;
    }

    public void setNombre_localidades(String nombre_localidades) {
        this.nombre_localidades = nombre_localidades;
    }
}
