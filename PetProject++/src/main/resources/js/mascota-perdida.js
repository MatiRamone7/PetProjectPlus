function enviar() {
  var nombre=document.getElementById('nombre').value;
  var apellido=document.getElementById('apellido').value;
  var numeroDni=document.getElementById('nroDocumento').value;
  var fecha=document.getElementById('fechaNacimiento').value;
  var direction=document.getElementById('inpuDireccion').value;
  var email=document.getElementById('email').value;
  var telefono=document.getElementById('telefono').value;
  const form=document.getElementById('form');
  console.log('la fecha es '+fecha)
  console.log(email);
  console.log(nombre);
  let cantidadDevalidaciones=0;
  if(nombre===""){
    var inputNombre=document.getElementById('nombre');
    inputNombre.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(apellido===""){
    var inputApellido=document.getElementById('apellido');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(numeroDni===""){
    var inputApellido=document.getElementById('nroDocumento');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(fecha===""){
    var inputApellido=document.getElementById('fechaNacimiento');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(direction===""){
    var inputApellido=document.getElementById('inpuDireccion');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(email===""){
    var inputEmail=document.getElementById('email');
    inputEmail.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(telefono===""){
    var inputApellido=document.getElementById('telefono');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  cantidadDevalidaciones ===7?form.submit():alert('llene los campos faltantes');
  // window.location.href = 'mascotas-encontradas.html';
  }