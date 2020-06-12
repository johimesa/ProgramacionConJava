function validarForma(forma) {
    // Usuario
    var usuario = forma.usuario;
    console.log(usuario.value);
    if(usuario.value == "Escribir usuario" || usuario.value == "") {
        alert("Se debe de ingresar un usuario válido.");
        usuario.focus();
        usuario.select();

        return false;
    }

    // Clave
    var clave = forma.clave;
    if(clave.value == "" || clave.value.length < 3) {
        alert("Se debe de ingresar una clave válida, al menos a 3 caracteres.");
        usuario.focus();
        usuario.select();

        return false;
    }

    // Tecnologías
    var tecnologias = forma.tecnologia;
    var checked = false;
    for (var i = 0; i < tecnologias.length; i++) {
        if(tecnologias[i].checked) {
            checked = true;
        }
    }

    if(!checked) {
        alert("Debe seleccionar al menos una tecnología!")
        return false;
    }

    // Géneros
    var generos = forma.genero;
    var radioSelec = false;
    for (var i = 0; i < generos.length; i++) {
        if(generos[i].checked) {
            radioSelec = true;
        }
    }

    if(!radioSelec) {
        alert("Debe seleccionar al menos una tecnología!")
        return false;
    }

    // Ocupación
    var ocupacion = forma.ocupacion;
    if(ocupacion.value == "") {
        alert("Debe seleccionar una ocupación!")
        return false;
    }

    return true;
}