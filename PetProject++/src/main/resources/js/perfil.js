
function guardarPerfil(){
    document.getElementById('nombre').setAttribute("disabled","disabled");
    document.getElementById('email').setAttribute("disabled","disabled");
    document.getElementById('telefono').setAttribute("disabled","disabled");
    document.getElementById('direccion').setAttribute("disabled","disabled");
    document.getElementById('guardar').setAttribute("hidden","hidden");
    document.getElementById('editar').removeAttribute("hidden");
}

function editarPerfil(){
    document.getElementById('nombre').removeAttribute("disabled");
    document.getElementById('email').removeAttribute("disabled");
    document.getElementById('telefono').removeAttribute("disabled");
    document.getElementById('direccion').removeAttribute("disabled");
    document.getElementById('guardar').removeAttribute("hidden");
    document.getElementById('editar').setAttribute("hidden","hidden");
}