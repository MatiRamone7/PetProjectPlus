package com.utn.contactservices;

public class Whatsapp {
    public void contactar(String destinatario, String asunto, String cuerpo) throws IOException {
        String token = "token de wabox";
        String numero = "minumero";
        String id = "id unico de mensaje";
        Wabox.enviarWhatsapp(token, numero, destinatario, id, cuerpo);
    } //no anda al no haber cuenta de wabox
}
