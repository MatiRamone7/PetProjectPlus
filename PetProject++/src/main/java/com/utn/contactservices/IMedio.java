package com.utn.contactservices;

import com.utn.models.users.ContactoUnico;

public interface IMedio {
    public void contactar(String asunto, String cuerpo, ContactoUnico contacto);
}
