package com.utn.contactservices.mensajesPredeterminados;

public interface IMensajePredet {
    public String textoDeUsuario = null;

    public String cuerpo();

    public String asunto();

    public void cambiarTexto(String input);
}
