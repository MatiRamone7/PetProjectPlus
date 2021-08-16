package com.utn.contactservices;

import com.utn.contactservices.services.JavaMail;

/*
 * DETALLES:
 *
 * 1. Necesario que la cuenta de mail del remitente tenga habilitado el "Acceso de apps menos seguras"
 * 2. Ver alguna manera de guardar mejor la contraseÃ±a del remitente q con un string en el cÃ³digo
 * 3. Crear una cuenta de mail/alias para usar como remitente
 * 4. Ver de configurar el estilo del mail ya que existe una manera de ponerle formato con html
 *
 * */

public class MMail implements IMedio{
    public static void contactar(String destinatario, String asunto, String cuerpo){
        String remitente = "";  //Lo que va adelante del @gmail.com
        JavaMail.enviarMail(destinatario,asunto,cuerpo,remitente);
    }
}