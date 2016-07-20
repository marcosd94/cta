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
public class Usuarios {
    private int id_usuarios;
    private String nombre_usuarios;
    private String usuario_usuarios;
    private String clave_usuarios;

    public Usuarios() {
    }

    public Usuarios(int id_usuarios, String nombre_usuarios, String usuario_usuarios, String clave_usuarios) {
        this.id_usuarios = id_usuarios;
        this.nombre_usuarios = nombre_usuarios;
        this.usuario_usuarios = usuario_usuarios;
        this.clave_usuarios = clave_usuarios;
    }

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombre_usuarios() {
        return nombre_usuarios;
    }

    public void setNombre_usuarios(String nombre_usuarios) {
        this.nombre_usuarios = nombre_usuarios;
    }

    public String getUsuario_usuarios() {
        return usuario_usuarios;
    }

    public void setUsuario_usuarios(String usuario_usuarios) {
        this.usuario_usuarios = usuario_usuarios;
    }

    public String getClave_usuarios() {
        return clave_usuarios;
    }

    public void setClave_usuarios(String clave_usuarios) {
        this.clave_usuarios = clave_usuarios;
    }

}
