package com.utn.contactservices;

import com.utn.contactservices.services.Vonage;

public class MSMS implements IMedio{
    public static void contactar(String destinatario, String asunto, String cuerpo) {
        Vonage.enviarMensaje(destinatario,cuerpo);
    }
}
