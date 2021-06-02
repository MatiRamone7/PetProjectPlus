package com.utn.contactservices;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/*
 * DETALLES:
 *
 * 1. Necesario que la cuenta de mail del remitente tenga habilitado el "Acceso de apps menos seguras"
 * 2. Ver alguna manera de guardar mejor la contraseÃ±a del remitente q con un string en el cÃ³digo
 * 3. Crear una cuenta de mail/alias para usar como remitente
 * 4. Ver de configurar el estilo del mail ya que existe una manera de ponerle formato con html
 *
 * */

public class Mail {
    public static void enviarMail(String destinatario, String asunto, String cuerpo){
        String remitente = "";  //Lo que va adelante del @gmail.com

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //Servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, ""); //CLAVE DE MAIL
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (
                MessagingException me) {
            me.printStackTrace();
        }
    }
}
