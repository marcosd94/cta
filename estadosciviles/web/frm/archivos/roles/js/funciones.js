function buscarIdRol() {
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servido..");
        },
        success: function (roles){
            $("#mensajes").html(roles.mensaje);
            $("#id_roles").val(roles.id_roles);
            $("#nombre_roles").val(roles.nombre_roles);
            if(roles.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_roles", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_roles", "#botonModificar",true)
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
}function buscarIdRol() {
    var datosFormulario=$("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto){
            $("#mensajes").html("Enviando datos al servido..");
        },
        success: function (roles){
            $("#mensajes").html(roles.mensaje);
            $("#id_roles").val(roles.id_roles);
            $("#nombre_roles").val(roles.nombre_roles);
            if(roles.nuevo === "true"){
                $("#botonAgregar").prop('disabled',false);
                $("#botonModificar").prop('disabled',true);
                $("#botonEliminar").prop('disabled',true);
                siguienteCampo("#nombre_roles", "#botonAgregar",true)
            } else {
                
                $("#botonAgregar").prop('disabled',true);
                $("#botonModificar").prop('disabled',false);
                $("#botonEliminar").prop('disabled',false);
                siguienteCampo("#nombre_roles", "#botonModificar",true)
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
function buscarNombreRol(){
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/buscarNombre.jsp",
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (roles) {
            $("#mensajes").html(roles.mensaje);
            $("#contenidoBusqueda").html(roles.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("#contenidoBusqueda tr").on("click",function (){
                var id= $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_roles").val(id);
                $("#nombre_roles").focus();
                buscarIdRol();
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
function modificarRol() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/modificar.jsp",
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (roles) {
            $("#mensajes").html(roles.mensaje);
                    limpiarFormulario();
            $("#id_roles").focus();
            $("#id_roles").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_roles").focus();
        }

    });
}
function eliminarRol() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: "jsp/eliminar.jsp",
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (roles) {
            $("#mensajes").html(roles.mensaje);
                    limpiarFormulario();
            $("#id_roles").focus();
            $("#id_roles").select();
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
    if($("#nombre_roles").val().trim()===""){
        valor=false;
        $("#mensajes").html("Nombre no puede estar vacio");
        $("#nombre_roles").focus();
    }
    return valor;
}
function limpiarFormulario(){
    $("#id_roles").val("0");
    $("#nombre_roles").val("");
}

function AgregarRol(){
    var datosFormulario = $("#formPrograma").serialize();
    alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: "jsp/agregar.jsp",
        data: datosFormulario,
        dataType: 'roles',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor..");
        },
        success: function (roles) {
            $("#mensajes").html(roles.mensaje);
                    limpiarFormulario();
            $("#id_roles").focus();
            $("#id_roles").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos");
        },
        complete: function (objeto,exito,error) {
            $("#id_roles").focus();
        }

    });
}
