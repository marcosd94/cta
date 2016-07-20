function buscarIdEstadoCivil() {
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
            $("#id_estadocivil").val(json.id_estadocivil);
            $("#nombre_estadocivil").val(json.nombre_estadocivil);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_estadocivil", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_estadocivil", "#botonModificar",true)
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
}function buscarIdEstadoCivil() {
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
            $("#id_estadocivil").val(json.id_estadocivil);
            $("#nombre_estadocivil").val(json.nombre_estadocivil);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_estadocivil", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_estadocivil", "#botonModificar",true)
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
function buscarNombreEstadoCivil(){
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
                $("#id_estadocivil").val(id);
                $("#nombre_estadocivil").focus();
                buscarIdEstadoCivil();
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
function modificarEstadoCivil() {
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
            $("#id_estadocivil").focus();
            $("#id_estadocivil").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_estadocivil").focus();
        }

    });
}
function eliminarEstadoCivil() {
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
            $("#id_estadocivil").focus();
            $("#id_estadocivil").select();
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
    if($("#nombre_estadocivil").val().trim()===""){
        valor=false;
        $("#mensajes").html("Nombre no puede estar vacio");
        $("#nombre_estadocivil").focus();
    }
    return valor;
}
function limpiarFormulario(){
    $("#id_estadocivil").val("0");
    $("#nombre_estadocivil").val("");
}

function AgregarEstadoCivil(){
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
            $("#id_estadocivil").focus();
            $("#id_estadocivil").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_estadocivil").focus();
        }

    });
}
