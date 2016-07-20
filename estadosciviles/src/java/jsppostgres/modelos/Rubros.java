/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.modelos;

public class Rubros {
    private int id_rubros;
    private String nombre_rubros;

    public Rubros() {
    }

    public Rubros(int id_rubros, String nombre_rubros) {
        this.id_rubros = id_rubros;
        this.nombre_rubros = nombre_rubros;
    }

    public int getId_rubros() {
        return id_rubros;
    }

    public void setId_rubros(int id_rubros) {
        this.id_rubros = id_rubros;
    }

    public String getNombre_rubros() {
        return nombre_rubros;
    }

    public void setNombre_rubros(String nombre_rubros) {
        this.nombre_rubros = nombre_rubros;
    }
    
}
