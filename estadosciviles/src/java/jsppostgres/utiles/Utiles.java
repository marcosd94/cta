/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsppostgres.utiles;
public class Utiles {
    public static final int REGISTROS_PAGINA=10;
    
    public static String quitarGuiones(String texto){
        return texto.replace("--","");
    }
    
}
