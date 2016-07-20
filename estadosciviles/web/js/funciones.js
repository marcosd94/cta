
function siguienteCampo(actual, siguiente, preventDefault) {
    $(actual).keydown(function (event) {
        if (event.which === 13) {
            if (preventDefault) {
                event.preventDefault();
            }
            $(siguiente).focus();
            $(siguiente).select();
        }
    });
}
function enterCampo(actual,ejecutar) {
    $(actual).keydown(function (event) {
        if (event.which === 13) {
            eval(ejecutar);
        }
    });
}

