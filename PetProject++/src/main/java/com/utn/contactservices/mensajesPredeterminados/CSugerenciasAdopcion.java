package com.utn.contactservices.mensajesPredeterminados;

public class CSugerenciasAdopcion implements IMensajePredet  {
    public String mensajePredet (String textoDeUsuario){
        String retorno = "Considerando adoptar?" +
        "Aquí te traemos una lista de mascotas que están buscando dueño \t " + textoDeUsuario;
        return retorno;
    };

    public String asunto (){
        return "Te traemos una serie de sugerecias para adoptar";
    };
}
