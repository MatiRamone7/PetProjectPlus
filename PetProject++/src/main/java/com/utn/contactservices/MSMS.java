package com.utn.contactservices;

import com.utn.contactservices.services.Vonage;
import com.utn.models.users.ContactoUnico;

public class MSMS implements IMedio{
    public static Vonage sms = new Vonage();

    public void contactar(String asunto, String cuerpo, ContactoUnico contacto){
        sms.enviarMensaje(contacto.celular,cuerpo);
    }

    public MSMS() {
    }
}
