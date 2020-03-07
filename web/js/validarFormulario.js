$(document).ready(function () {
    $('#formularioMedicamento').bootstrapValidator({
        fields: {
            nombre: {
                validators: {
                    notEmpty: {
                        message: 'El nombre del medicamento es obligatorio'
                    },
                    stringLength: {
                        min: 3,
                        max: 40,
                        message: 'Ingrese le nombre del medicamento que tenga entre 3 y 40 caracteres.'
                    }
                }
            },
            precio: {
                validators: {
                    notEmpty: {
                        message: 'Debe ingresar el precio'
                    }
                }
            },
            gramos: {
                validators: {
                    notEmpty: {
                        message: 'Debe ingresar la cantidad de gramos que contiene.'
                    }
                }
            },
            laboratorio: {
                validators: {
                    notEmpty: {
                        message: 'Seleccione una opcion'
                    }
                }
            }
        }
    });
});

function validarNumeros(e) {
    var keynum = window.event ? window.event.keyCode : e.which;
    if ((keynum == 8) || (keynum == 46))
        return true;

    return /\d/.test(String.fromCharCode(keynum));
}
