function buscarIdMenu() {
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
            $("#id_menus").val(json.id_menus);
            $("#nombre_menus").val(json.nombre_menus);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_menus", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_menus", "#botonModificar",true)
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
function buscarIdMenu() {
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
            $("#id_menus").val(json.id_menus);
            $("#nombre_menus").val(json.nombre_menus);
            $("#codigo_menus").val(json.codigo_menus);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_menus", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_menus", "#botonModificar",true)
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
function buscarNombreMenu(){
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
                $("#id_menus").val(id);
                $("#nombre_menus").focus();
                buscarIdMenu();
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
function modificarMenu() {
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
            $("#id_menus").focus();
            $("#id_menus").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_menus").focus();
        }

    });
}
function eliminarMenu() {
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
            $("#id_menus").focus();
            $("#id_menus").select();
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
    if($("#nombre_menus").val().trim()===""){
        valor=false;
        $("#mensajes").html("Nombre no puede estar vacio");
        $("#nombre_menus").focus();
    }
    return valor;
}
function limpiarFormulario(){
    $("#id_menus").val("0");
    $("#nombre_menus").val("");
}

function AgregarMenu(){
    var datosFormulario = $("#formPrograma").serialize();
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
            $("#id_menus").focus();
            $("#id_menus").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_menus").focus();
        }

    });
}
