package com.utn.models.contactservices.mensajesPredeterminados;

import com.utn.models.forms.FormularioMascotaPerdida;

public class CQRScaneado implements IMensajePredet {
    public String textoDeUsuario = null;

    public FormularioMascotaPerdida form;
    
    public CQRScaneado(FormularioMascotaPerdida unForm){
        form = unForm;
    }

    public CQRScaneado(String input){
        textoDeUsuario = input;
    }
    
    public String cuerpo(){
        String retorno = "El QR de " + form.getMascota().getApodo() + " fue escaneado por el rescatista " +
        form.getNombre() + "\n" + "Para comunicarte por tu mascota: ";
        if(!form.getContacto().getCelular().isEmpty()){
            retorno = retorno + form.getContacto().getCelular() + " - ";
        }
        if(!form.getContacto().getMail().isEmpty()){
            retorno = retorno + form.getContacto().getMail();
        }
        return retorno;
    };
    
    public String asunto (){
        return "QR de mascota escaneado";
    };
    
    public void cambiarTexto(String input){
        textoDeUsuario = input;
    }
    
    public FormularioMascotaPerdida getForm() {
        return form;
    }
    
    public void setForm(FormularioMascotaPerdida form) {
        this.form = form;
    }
}
