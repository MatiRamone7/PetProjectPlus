package com.utn.contactservices;

import com.utn.models.users.ContactoUnico;

public interface IMedio {
    public static void contactar(String asunto, String cuerpo, ContactoUnico contacto){};
}
