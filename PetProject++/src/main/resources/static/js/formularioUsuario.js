function validar() {
  var nombre=document.getElementById('nombre').value;
  var apellido=document.getElementById('apellido').value;
  var numeroDni=document.getElementById('nroDocumento').value;
  var fecha=document.getElementById('fechaNacimiento').value;
  var direction=document.getElementById('inpuDireccion').value;
  var email=document.getElementById('email').value;
  var telefono=document.getElementById('telefono').value;
  var nombreUsu=document.getElementById('nombreUsu').value;
  var password=document.getElementById('password').value;
  var confCont=document.getElementById('confCont').value;
  var check=document.getElementById('check').value;
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
  if(check===""){
    var inputApellido=document.getElementById('check');
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
  if(nombreUsu===""){
    var inputApellido=document.getElementById('nombreUsu');
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
  if(password===""){
    var inputApellido=document.getElementById('password');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  if(confCont===""){
    var inputApellido=document.getElementById('confCont');
    inputApellido.classList.add('is-invalid')
  }
  else{
    cantidadDevalidaciones++;
  }
  cantidadDevalidaciones ===11?form.submit():alert('llene los campos faltantes');
  // window.location.href = 'mascotas-encontradas.html';
  }

//document.addEventListener("", function (){document.getElementById("formulario").addEventListener("submit", )})


function prueba(){
  console.log('funciona el evento')
  let element = document.getElementById('list-estados');
  let elementStyle = window.getComputedStyle(element);
  let elementColor = elementStyle.getPropertyValue('display');
  if(elementColor==='none'){
    element.style.display = 'flex';
  }
  else{
    element.style.display = 'none';
  }
}
function prueba2(){
  console.log('funciona el evento')
  let element = document.getElementById('list-form');
  let elementStyle = window.getComputedStyle(element);
  let elementColor = elementStyle.getPropertyValue('display');
  if(elementColor==='none'){
    element.style.display = 'flex';
  }
  else{
    element.style.display = 'none';
  }
}
function confirmarContrasena(){
  console.log('funciona el evento')
  const confirmacion=document.getElementById('confCont').value;
  const contrasena = document.getElementById('password').value;
  if(confirmacion===contrasena){
    console.log('son iguales');
  }
  else{
    confirmacion=document.getElementById('confCont');
    confirmacion.classList.add('is-invalid')
  }
  
}

function validarContrasena(){
  const contrasena = document.getElementById('password').value;
  
  var regularExpression = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,64}$/;
  if(!regularExpression.test(contrasena)){
    var inputApellido=document.getElementById('password');
    inputApellido.classList.add('is-invalid')
  }
}

function verOpciones(caracteristica){
  window.location.href = '/Preguntas-Mascotas/Respuestas/' + caracteristica.toString();
}