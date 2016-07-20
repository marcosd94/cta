function buscarIdArticulo() {
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servido..");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);
            $("#id_articulos").val(json.id_articulos);
            $("#nombre_articulos").val(json.nombre_articulos);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_articulos", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_articulos", "#botonModificar",true)
            }
        },
        error: function (e){
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}function buscarIdArticulo() {
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servido..");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);
            $("#id_articulos").val(json.id_articulos);
            $("#nombre_articulos").val(json.nombre_articulos);
            $("#codigo_articulos").val(json.codigo_articulos);
            $("#serie_articulos").val(json.serie_articulos);
            $("#id_rubros").val(json.id_rubros);
            $("#nombre_rubros").val(json.nombre_rubros);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_articulos", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_articulos", "#botonModificar",true)
            }
        },
        error: function (e){
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}
function buscarNombreArticulo(){
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/buscarNombre.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("#contenidoBusqueda tr").on("click",function (){
                var id= $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_articulos").val(id);
                $("#nombre_articulos").focus();
                buscarIdArticulo();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}
function buscarNombreRubro(){
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/buscarNombre.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("#contenidoBusqueda tr").on("click",function (){
                var id= $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_rubros").val(id);
                $("#nombre_rubros").focus();
                buscarIdRubro();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}
function modificarArticulo() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/modificar.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
                    limpiarFormulario();
            $("#id_articulos").focus();
            $("#id_articulos").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_articulos").focus();
        }

    });
}
function eliminarArticulo() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/eliminar.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
                    limpiarFormulario();
            $("#id_articulos").focus();
            $("#id_articulos").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}
function ValidarFormulario(){
    var valor = true;
    if($("#nombre_articulos").val().trim()==="" ||$("#codigo_articulos").val().trim()==="" || $("#serie_articulos").val().trim()===""  ){
        valor=false;
        $("#mensajes").html("Nombre, Codigo o Articulo no puede estar vacio");
        $("#nombre_articulos").focus();
    }
    return valor;
}
function limpiarFormulario(){
    $("#id_articulos").val("0");
    $("#nombre_articulos").val("");
    $("#codigo_articulos").val("");
    $("#serie_articulos").val("");
    $("#id_rubros").val("");
    $("#nombre_rubros").val("");
}

function AgregarArticulo(){
    var datosFormulario = $("#formPrograma").serialize();
    alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: "jsp/agregar.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
                    limpiarFormulario();
            $("#id_articulos").focus();
            $("#id_articulos").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_articulos").focus();
        }

    });
}
function buscarIdRubro() {
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdRubro.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servido..");
        },
        success: function (json){
            $("#mensajes").html(json.mensaje);
            $("#id_rubros").val(json.id_rubros);
            $("#nombre_rubros").val(json.nombre_rubros);
        },
        error: function (e){
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}
function buscarNombreRubro(){
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/buscarNombreRubro.jsp",
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("#contenidoBusqueda tr").on("click",function (){
                var id= $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_rubros").val(id);
                $("#nombre_rubros").focus();
                buscarIdRubro();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros");
        },
        complete:function (objeto,exito,error){
            if(exito ==="success"){
                }
        }
    });
}