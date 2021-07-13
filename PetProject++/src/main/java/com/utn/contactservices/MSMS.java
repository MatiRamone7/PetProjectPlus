package com.utn.contactservices;

public class MSMS implements IMedio{
    public static void contactar(String destinatario, String asunto, String cuerpo) {
        Vonage.enviarMensaje(destinatario,cuerpo);
    }
}
