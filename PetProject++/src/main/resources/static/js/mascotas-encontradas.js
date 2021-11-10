function encontreUnaMascota() {
    window.location.href = 'Mascota-Perdida';
  }
  function enviarMensaje(){
    const popUp= document.getElementById('popUp');
    popUp.classList.add('verModal')
  }
  function salir(){
    const popUp= document.getElementById('popUp');
    popUp.classList.add('verModal')
  }
  function enviarMensaje(){
    const popUp= document.getElementById('popUp');
    popUp.classList.remove('verModal')
  }
  function quieroAdoptar() {
    window.location.href = 'Formulario-Quiero-Adoptar';
  }