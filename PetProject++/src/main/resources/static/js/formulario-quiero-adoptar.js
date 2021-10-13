function enviar() {
    window.location.href = 'mascotas-encontradas.html';
  }

  function prueba(sacar) {
    const preguntaASAcar=sacar.parentNode;
    const padre=preguntaASAcar.parentNode
    padre.removeChild(preguntaASAcar);
    console.log('agarro: '+preguntaASAcar.parentNode);
  }
  
  function agregar() {
  
  var input=document.getElementById('nuevaPregunta').value;
  var elemento=document.getElementById('nuevaPregunta');
  if(input===""){
  
  elemento.classList.add('is-invalid');
  }
  else{
    elemento.classList.remove('is-invalid');
    var padre=document.getElementById('padre');
    var caja =document.createElement('div');
    var salir =document.createElement('div');
    var x=document.createElement('p')
    var caxja =document.createTextNode('x');
    x.appendChild(caxja)
    var cajacontent =document.createElement('div');
    var pregunta =document.createTextNode(input);
    salir.appendChild(x);
    salir.setAttribute('class','eliminarPregunta');
    salir.setAttribute('onclick','prueba(this)')
    caja.appendChild(pregunta);
    caja.setAttribute('class','pregunta');
    cajacontent.appendChild(caja);
    cajacontent.setAttribute('class','prueba mt-3');
    cajacontent.appendChild(salir);
    padre.appendChild(cajacontent);
    elemento.value="";
  }
   
    
  
  }