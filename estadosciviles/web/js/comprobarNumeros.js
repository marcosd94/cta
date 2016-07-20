/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function comprobar(){
              var valor=document.formularioRecogidaDatos.valor.value;
              
                if (valor===""){
                        alert("Introduzca Numeros Enteros");
                        document.formularioRecogidaDatos.valor.focus();
                        return false;
                    }
                    
              
                if(isNaN(valor)){
                    alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor.value="";
                        document.formularioRecogidaDatos.valor.focus();

                         return false;
                }
               
            return true;
            }
function comprobarSuma (){
                var valor1=document.formularioRecogidaDatos.valor1.value;
                var valor2=document.formularioRecogidaDatos.valor2.value;
                
                    if (valor1===""|| valor2===""){
                        alert("Introduzca Numeros Enteros");
                        document.formularioRecogidaDatos.valor1.focus();
                        return false;
                    }
                    
                
                    if (isNaN(valor1)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor1.value="";
                        document.formularioRecogidaDatos.valor1.focus();
                        
                    return false;
                    }
                    if (isNaN(valor2)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                    return false;
                    }
                return true;         
}
function comprobarResta (){
                var valor1=document.formularioRecogidaDatos.valor1.value;
                var valor2=document.formularioRecogidaDatos.valor2.value;
                
                    if (valor1===""|| valor2===""){
                        alert("Introduzca Numeros Enteros");
                        document.formularioRecogidaDatos.valor1.focus();
                        return false;
                    }
                    
                    if (valor1<valor2){
                        alert("El primer valor debe ser mayor al segundo");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                        return false;
                    }
                    if (isNaN(valor1)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor1.value="";
                        document.formularioRecogidaDatos.valor1.focus();
                        
                    return false;
                    }
                    if (isNaN(valor2)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                    return false;
                    }
                return true;         
}

function comprobarMultiplicacion(){
                var valor1=document.formularioRecogidaDatos.valor1.value;
                var valor2=document.formularioRecogidaDatos.valor2.value;
                
                    if (valor1===""|| valor2===""){
                        alert("Introduzca Numeros Enteros");
                        document.formularioRecogidaDatos.valor1.focus();
                        return false;
                    }
                    if (isNaN(valor1)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor1.value="";
                        document.formularioRecogidaDatos.valor1.focus();
                        
                    return false;
                    }
                    if (isNaN(valor2)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                    return false;
                    }
                return true;         
}
function comprobarDivision(){
                var valor1=document.formularioRecogidaDatos.valor1.value;
                var valor2=document.formularioRecogidaDatos.valor2.value;
                
                    if (valor1===""|| valor2===""){
                        alert("Introduzca Numeros Enteros");
                        document.formularioRecogidaDatos.valor1.focus();
                        return false;
                    }
                    if (valor2==="0"){
                        alert("El valor debe no puede ser 0");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                        
                    return false;
                    }
                    if (isNaN(valor1)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor1.value="";
                        document.formularioRecogidaDatos.valor1.focus();
                        
                    return false;
                    }
                    if (isNaN(valor2)){
                        alert("El valor debe ser numerico");
                        document.formularioRecogidaDatos.valor2.value="";
                        document.formularioRecogidaDatos.valor2.focus();
                    return false;
                    }
                return true;         
}