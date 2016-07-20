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
public class Articulos {

    private int id_articulos;
    private String nombre_articulos;
    private String codigo_articulos;
    private String serie_articulos;
    private Rubros rubro;
    
    

    public Articulos() {
    } 

    public Articulos(int id_articulos, String nombre_articulos, String codigo_articulos, String serie_articulos, Rubros rubro) {
        this.id_articulos = id_articulos;
        this.nombre_articulos = nombre_articulos;
        this.codigo_articulos = codigo_articulos;
        this.serie_articulos = serie_articulos;
        this.rubro = rubro;
    } 

    public int getId_articulos() {
        return id_articulos;
    }

    public void setId_articulos(int id_articulos) {
        this.id_articulos = id_articulos;
    }

    public String getNombre_articulos() {
        return nombre_articulos;
    }

    public void setNombre_articulos(String nombre_articulos) {
        this.nombre_articulos = nombre_articulos;
    }

    public String getCodigo_articulos() {
        return codigo_articulos;
    }

    public void setCodigo_articulos(String codigo_articulos) {
        this.codigo_articulos = codigo_articulos;
    }

    public String getSerie_articulos() {
        return serie_articulos;
    }

    public void setSerie_articulos(String serie_articulos) {
        this.serie_articulos = serie_articulos;
    }

    public Rubros getRubro() {
        return rubro;
    }

    public void setRubro(Rubros rubro) {
        this.rubro = rubro;
    }
}
