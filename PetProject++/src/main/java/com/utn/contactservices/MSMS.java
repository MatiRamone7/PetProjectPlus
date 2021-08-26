package com.utn.contactservices;

import com.utn.contactservices.services.Vonage;
import com.utn.models.ContactoUnico;

public class MSMS implements IMedio{
    public static Vonage sms = new Vonage();

    public static void contactar(String asunto, String cuerpo, ContactoUnico contacto){
        sms.enviarMensaje(contacto.celular,cuerpo);
    }
}
