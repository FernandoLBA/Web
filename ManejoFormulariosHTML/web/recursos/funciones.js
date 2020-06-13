function validarForma(forma){
    //validamos el usuario
    var usuario = forma.usuario;
    if (usuario.value == "" || usuario.value == "Escribir usuario") {
        alert("Debe colocar el nombre de usuario.");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    //validamos el password
    var password = forma.password;
    if (password.value == "" || password.value.length < 3) {
        alert("De proporcionar una contraseña de mas de 2 caracteres.");
        password.focus();
        password.select();
        return false;
    }
    
    //Validamos las tecnologías de interés
    var tecnologias = forma.tecnologia;
    var checkSeleccionado = false;
    
    for (var i = 0; i < tecnologias.length; i++) {
        if (tecnologias[i].checked) {
            checkSeleccionado = true;
        }
    }
    if (!checkSeleccionado) {
        alert("Debe seleccionar una tecnología.");
        return false;
    }
    
    //Validamos el género
    var genero = forma.genero;
    var radioSeleccionado = false;
    for (var i = 0; i < genero.length; i++) {
        if (genero[i].checked) {
            radioSeleccionado = true;
        }
    }
    if (!radioSeleccionado) {
        alert("Seleccione un género.");
        return false;
    }
    
    //Validamos ocupación
    var ocupacion = forma.ocupacion;
    if (ocupacion.value=="") {
        alert("Por favor seleccione una ocupación;");
        return false;
    }
    
    //Formulario validado
    alert("Formulario válido, enviando datos...");
}


