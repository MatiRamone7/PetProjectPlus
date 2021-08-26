package com.utn.contactservices;

import java.io.IOException;

import com.utn.contactservices.services.Wabox;
import com.utn.contactservices.services.WhatsappRespuesta;
import com.utn.models.ContactoUnico;
public class MWhatsapp implements IMedio{
    private String numero;
    public static Wabox wp = new Wabox();

    public void contactar(String asunto, String cuerpo, ContactoUnico contacto){
        String token = "token de wabox";
        numero = "minumero";
        String id = "id unico de mensaje";
        try {
            wp.enviarWhatsapp(token, numero, contacto.celular, id, cuerpo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    public WhatsappRespuesta enviarWhatsapp(String token, String numero, String to, String id, String texto) throws IOException {
        WhatsappRespuesta rta = wp.enviarWhatsapp(token, numero, to, id, texto);
        return rta;
    }
    //no anda al no haber cuenta de wabox
}
