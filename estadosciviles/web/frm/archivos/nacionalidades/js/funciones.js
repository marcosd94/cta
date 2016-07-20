function buscarIdProfesion() {
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
            $("#id_profesiones").val(json.id_profesiones);
            $("#nombre_profesiones").val(json.nombre_profesiones);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_profesiones", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_profesiones", "#botonModificar",true)
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
}function buscarIdProfesion() {
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
            $("#id_profesiones").val(json.id_profesiones);
            $("#nombre_profesiones").val(json.nombre_profesiones);
            if(json.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_profesiones", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_profesiones", "#botonModificar",true)
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
function buscarNombreProfesion(){
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
                $("#id_profesiones").val(id);
                $("#nombre_profesiones").focus();
                buscarIdProfesion();
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
function modificarProfesion() {
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
            $("#id_profesiones").focus();
            $("#id_profesiones").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_profesiones").focus();
        }

    });
}
function eliminarProfesion() {
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
            $("#id_profesiones").focus();
            $("#id_profesiones").select();
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
    if($("#nombre_profesiones").val().trim()===""){
        valor=false;
        $("#mensajes").html("Nombre no puede estar vacio");
        $("#nombre_profesiones").focus();
    }
    return valor;
}
function limpiarFormulario(){
    $("#id_profesiones").val("0");
    $("#nombre_profesiones").val("");
}

function AgregarProfesion(){
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
            $("#id_profesiones").focus();
            $("#id_profesiones").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_profesiones").focus();
        }

    });
}
