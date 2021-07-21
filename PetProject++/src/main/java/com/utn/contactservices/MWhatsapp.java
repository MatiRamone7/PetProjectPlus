package com.utn.contactservices;

import java.io.IOException;

import com.utn.contactservices.services.Wabox;
import com.utn.contactservices.services.WhatsappRespuesta;
public class MWhatsapp implements IMedio{
    private String numero;

    public void contactar(String destinatario, String asunto, String cuerpo) throws IOException {
        String token = "token de wabox";
        numero = "minumero";
        String id = "id unico de mensaje";
        Wabox.instancia().enviarWhatsapp(token, numero, destinatario, id, cuerpo);
    } 
    
    public WhatsappRespuesta enviarWhatsapp(String token, String numero, String to, String id, String texto) throws IOException {
        WhatsappRespuesta rta = Wabox.instancia().enviarWhatsapp(token, numero, to, id, texto);
        return rta;
    }
    //no anda al no haber cuenta de wabox
}
